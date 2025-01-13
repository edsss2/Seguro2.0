package view.empresa;

import java.awt.event.ActionEvent;

import dao.DaoImages;
import view.PainelImagens;
import view.TelaPrincipal;

public class TelaFoto2 extends TelaFoto {

	private static final long serialVersionUID = 1L;

	public TelaFoto2(TelaPrincipal telaPrincipal, PainelImagens painelImagens) {
		super(telaPrincipal, "ADICIONE AS FOTOS DA RESIDÊNCIA", "2- Número da Residência", painelImagens);					
	}

	@Override
	protected void acaoProsseguir(ActionEvent e) {
		dispose();

		telaPrincipal.tf3 = new TelaFoto3(telaPrincipal, painelImagens);
		telaPrincipal.tf3.setVisible(true);
	}
	
	@Override 
	protected void salvarFotoCarregada() {
		DaoImages dao = new DaoImages();
		int a = dao.getIdEmpresa() - 1;
		dao.setIdEmpresa(a);

		dao.salvarImagem("numero", fis, tamanho);
	}
	
}
