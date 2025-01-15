package view.empresa;

import java.awt.event.ActionEvent;

import dao.DaoImages;
import view.PainelImagens;
import view.TelaPrincipal;

public class TelaFoto3 extends TelaFoto {

	private static final long serialVersionUID = 1L;

	public TelaFoto3(TelaPrincipal telaPrincipal, PainelImagens painelImagens) {
		super(telaPrincipal, "ADICIONE AS FOTOS DA RESIDÊNCIA", "3- Medidor de Energia", painelImagens);
	}
	
	@Override
	protected void acaoProsseguir(ActionEvent e) {
		dispose();
		
		if (telaPrincipal.tf4 == null) {
			telaPrincipal.tf4 = new TelaFoto4(telaPrincipal, painelImagens);
		}
		telaPrincipal.tf4.setVisible(true);
	}
	
	@Override
	protected void salvarFotoCarregada() {
		DaoImages dao = new DaoImages();
		int a = dao.getIdEmpresa() - 1;
		dao.setIdEmpresa(a);
		
		dao.salvarImagem("medidor", fis, tamanho);
	}
}
