package view.empresa;

import java.awt.event.ActionEvent;

import dao.DaoImagesE;
import view.TelaPrincipal;

public class TelaFotoEquipamento3 extends TelaFoto {

	private static final long serialVersionUID = 1L;
	
	public TelaFotoEquipamento3(TelaPrincipal telaPrincipal) {
		super(telaPrincipal, "ADICIONE AS FOTOS DO EQUIPAMENTO", "3- Verso");
	}

	@Override
	protected void acaoProsseguir(ActionEvent e) {
		dispose();
		telaPrincipal.tfe4 = new TelaFotoEquipamento4(telaPrincipal);
		telaPrincipal.tfe4.setVisible(true);
		
	}
	
	@Override 
	protected void salvarFotoCarregada() {
		DaoImagesE dao = new DaoImagesE();
		int a = dao.getIdEquipamento() - 1;
		dao.setIdEquipamento(a);
		
		dao.salvarImagem("verso", fis, tamanho);
	}

}
