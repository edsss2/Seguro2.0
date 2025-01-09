package view.empresa;

import java.awt.event.ActionEvent;

import dao.DaoImages;
import view.TelaPrincipal;

public class TelaFoto1 extends TelaFoto {

	private static final long serialVersionUID = 1L;

	public TelaFoto1(TelaPrincipal telaPrincipal) {
		super(telaPrincipal, "ADICIONE AS FOTOS DA RESIDÊNCIA", "1- Fachada da Residência");
	}

	@Override
	protected void acaoProsseguir(ActionEvent e) {
		dispose();
		telaPrincipal.telaFoto2 = new TelaFoto2(telaPrincipal);
		telaPrincipal.telaFoto2.setVisible(true);
		
	}
	
	@Override 
	protected void salvarFotoCarregada() {
		DaoImages dao = new DaoImages();

		dao.criarEmpresa();
		dao.salvarImagem("fachada", fis, tamanho);
	}
	
	
}
	