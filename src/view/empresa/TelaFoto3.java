package view.empresa;

import dao.DaoImages;
import view.PainelImagens;
import view.TelaPrincipal;
import java.awt.event.ActionEvent;

public class TelaFoto3 extends TelaFoto {

	private static final long serialVersionUID = 1L;

	public TelaFoto3(TelaPrincipal telaPrincipal, PainelImagens painelImagens) {
		super(telaPrincipal, "ADICIONE AS FOTOS DA RESIDÊNCIA", "3- Medidor de Energia", painelImagens);
	}
	
	@Override
	protected void acaoProsseguir(ActionEvent e) {
		dispose();
		
		telaPrincipal.tf4 = new TelaFoto4(telaPrincipal, painelImagens);
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
