package view.empresa;

import java.awt.event.ActionEvent;

import dao.DaoImages;
import view.PainelImagens;
import view.TelaPrincipal;

public class TelaFoto1 extends TelaFoto {

	private static final long serialVersionUID = 1L;

	public TelaFoto1(TelaPrincipal telaPrincipal, PainelImagens painelImagens) {
		super(telaPrincipal, "ADICIONE AS FOTOS DA RESIDÊNCIA", "1- Fachada da Residência", painelImagens);
	}

	@Override
	protected void acaoProsseguir(ActionEvent e) {
		dispose();
		if (telaPrincipal.tf2 == null) {
			telaPrincipal.tf2 = new TelaFoto2(telaPrincipal, painelImagens);
		}
		telaPrincipal.tf2.setVisible(true);
		
	}
	
	@Override 
	protected void salvarFotoCarregada() {
		DaoImages dao = new DaoImages();

		dao.criarEmpresa();
		dao.salvarImagem("fachada", fis, tamanho);
	}
	
	
}
	