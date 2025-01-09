package view.empresa;

import java.awt.event.ActionEvent;

import dao.DaoImagesE;
import view.TelaPrincipal;

public class TelaFotoEquipamento4 extends TelaFoto {

	private static final long serialVersionUID = 1L;
	
	public TelaFotoEquipamento4(TelaPrincipal telaPrincipal) {
		super(telaPrincipal, "ADICIONE AS FOTOS DO EQUIPAMENTO", "4- Evidências dos danos");
	}

	@Override
	protected void acaoProsseguir(ActionEvent e) {
		dispose();
		telaPrincipal.tfe5 = new TelaFotoEquipamento5(telaPrincipal);
		telaPrincipal.tfe5.setVisible(true);
		
		telaPrincipal.adicionarBotoes(telaPrincipal.abaEquipamento, 
										telaPrincipal.btnProsseguirEquipamento, 
										telaPrincipal.btnSalvarEquipamento);
		
	}
	
	@Override 
	protected void salvarFotoCarregada() {
		DaoImagesE dao = new DaoImagesE();
		int a = dao.getIdEquipamento() - 1;
		dao.setIdEquipamento(a);
		
		dao.salvarImagem("Evidência dos danos", fis, tamanho);
	}

}
