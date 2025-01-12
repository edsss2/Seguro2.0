package view.empresa;

import java.awt.event.ActionEvent;

import dao.DaoImages;
<<<<<<< HEAD
=======
import view.PainelImagens;
>>>>>>> 12d6876 (Abas separadas)
import view.TelaPrincipal;

public class TelaFoto1 extends TelaFoto {

	private static final long serialVersionUID = 1L;

<<<<<<< HEAD
	public TelaFoto1(TelaPrincipal telaPrincipal) {
		super(telaPrincipal, "ADICIONE AS FOTOS DA RESIDÊNCIA", "1- Fachada da Residência");
=======
	public TelaFoto1(TelaPrincipal telaPrincipal, PainelImagens painelImagens) {
		super(telaPrincipal, "ADICIONE AS FOTOS DA RESIDÊNCIA", "1- Fachada da Residência", painelImagens);
>>>>>>> 12d6876 (Abas separadas)
	}

	@Override
	protected void acaoProsseguir(ActionEvent e) {
		dispose();
<<<<<<< HEAD
		telaPrincipal.telaFoto2 = new TelaFoto2(telaPrincipal);
		telaPrincipal.telaFoto2.setVisible(true);
=======
		telaPrincipal.tf2 = new TelaFoto2(telaPrincipal, painelImagens);
		telaPrincipal.tf2.setVisible(true);
>>>>>>> 12d6876 (Abas separadas)
		
	}
	
	@Override 
	protected void salvarFotoCarregada() {
		DaoImages dao = new DaoImages();

		dao.criarEmpresa();
		dao.salvarImagem("fachada", fis, tamanho);
	}
	
	
}
	