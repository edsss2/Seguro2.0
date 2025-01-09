package view.empresa;

import java.awt.event.ActionEvent;

import dao.DaoImages;
import view.TelaPrincipal;

public class TelaFoto2 extends TelaFoto {

	private static final long serialVersionUID = 1L;

	public TelaFoto2(TelaPrincipal telaPrincipal) {
		super(telaPrincipal, "ADICIONE AS FOTOS DA RESIDÊNCIA", "2- Número da Residência");					
	}

	@Override
	protected void acaoProsseguir(ActionEvent e) {
		dispose();

		telaPrincipal.telaFoto3 = new TelaFoto3(telaPrincipal);
		telaPrincipal.telaFoto3.setVisible(true);
	}
	
	@Override 
	protected void salvarFotoCarregada() {
		DaoImages dao = new DaoImages();
		int a = dao.getIdEmpresa() - 1;
		dao.setIdEmpresa(a);

		dao.salvarImagem("numero", fis, tamanho);
	}
	
}
