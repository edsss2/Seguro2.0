package view.empresa;

import dao.DaoImages;
import view.TelaPrincipal;

import java.awt.event.ActionEvent;

public class TelaFoto3 extends TelaFoto {

	private static final long serialVersionUID = 1L;

	public TelaFoto3(TelaPrincipal telaPrincipal) {
		super(telaPrincipal, "ADICIONE AS FOTOS DA RESIDÊNCIA", "3- Medidor de Energia");
	}
	
	@Override
	protected void acaoProsseguir(ActionEvent e) {
		dispose();
		
		telaPrincipal.telaFoto4 = new TelaFoto4(telaPrincipal);
		telaPrincipal.telaFoto4.setVisible(true);
	}
	
	@Override
	protected void salvarFotoCarregada() {
		DaoImages dao = new DaoImages();
		int a = dao.getIdEmpresa() - 1;
		dao.setIdEmpresa(a);
		
		dao.salvarImagem("medidor", fis, tamanho);
	}
}
