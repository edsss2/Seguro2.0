package view.empresa;

import dao.DaoImages;
<<<<<<< HEAD
=======
import view.PainelImagens;
>>>>>>> 12d6876 (Abas separadas)
import view.TelaPrincipal;

import java.awt.event.ActionEvent;

public class TelaFoto3 extends TelaFoto {

	private static final long serialVersionUID = 1L;

<<<<<<< HEAD
	public TelaFoto3(TelaPrincipal telaPrincipal) {
		super(telaPrincipal, "ADICIONE AS FOTOS DA RESIDÊNCIA", "3- Medidor de Energia");
=======
	public TelaFoto3(TelaPrincipal telaPrincipal, PainelImagens painelImagens) {
		super(telaPrincipal, "ADICIONE AS FOTOS DA RESIDÊNCIA", "3- Medidor de Energia", painelImagens);
>>>>>>> 12d6876 (Abas separadas)
	}
	
	@Override
	protected void acaoProsseguir(ActionEvent e) {
		dispose();
		
<<<<<<< HEAD
		telaPrincipal.telaFoto4 = new TelaFoto4(telaPrincipal);
		telaPrincipal.telaFoto4.setVisible(true);
=======
		telaPrincipal.tf4 = new TelaFoto4(telaPrincipal, painelImagens);
		telaPrincipal.tf4.setVisible(true);
>>>>>>> 12d6876 (Abas separadas)
	}
	
	@Override
	protected void salvarFotoCarregada() {
		DaoImages dao = new DaoImages();
		int a = dao.getIdEmpresa() - 1;
		dao.setIdEmpresa(a);
		
		dao.salvarImagem("medidor", fis, tamanho);
	}
}
