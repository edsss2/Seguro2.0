package view.empresa;

import java.awt.event.ActionEvent;

import dao.DaoImages;
<<<<<<< HEAD
=======
import view.PainelImagens;
>>>>>>> 12d6876 (Abas separadas)
import view.TelaPrincipal;

public class TelaFoto2 extends TelaFoto {

	private static final long serialVersionUID = 1L;

<<<<<<< HEAD
	public TelaFoto2(TelaPrincipal telaPrincipal) {
		super(telaPrincipal, "ADICIONE AS FOTOS DA RESIDÊNCIA", "2- Número da Residência");					
=======
	public TelaFoto2(TelaPrincipal telaPrincipal, PainelImagens painelImagens) {
		super(telaPrincipal, "ADICIONE AS FOTOS DA RESIDÊNCIA", "2- Número da Residência", painelImagens);					
>>>>>>> 12d6876 (Abas separadas)
	}

	@Override
	protected void acaoProsseguir(ActionEvent e) {
		dispose();

<<<<<<< HEAD
		telaPrincipal.telaFoto3 = new TelaFoto3(telaPrincipal);
		telaPrincipal.telaFoto3.setVisible(true);
=======
		telaPrincipal.tf3 = new TelaFoto3(telaPrincipal, painelImagens);
		telaPrincipal.tf3.setVisible(true);
>>>>>>> 12d6876 (Abas separadas)
	}
	
	@Override 
	protected void salvarFotoCarregada() {
		DaoImages dao = new DaoImages();
		int a = dao.getIdEmpresa() - 1;
		dao.setIdEmpresa(a);

		dao.salvarImagem("numero", fis, tamanho);
	}
	
}
