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
		telaPrincipal.tfe5.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosed(java.awt.event.WindowEvent e) {
			            	
				telaPrincipal.trocarIcones(telaPrincipal.tfe1, telaPrincipal.equImagem1);
				telaPrincipal.trocarIcones(telaPrincipal.tfe2, telaPrincipal.equImagem2);
				telaPrincipal.trocarIcones(telaPrincipal.tfe3, telaPrincipal.equImagem3);
				telaPrincipal.trocarIcones(telaPrincipal.tfe4, telaPrincipal.equImagem4);
				telaPrincipal.trocarIcones(telaPrincipal.tfe5, telaPrincipal.equImagem5);
		
				telaPrincipal.adicionarBotoes(telaPrincipal.abaEquipamento, 
										telaPrincipal.btnProsseguirEquipamento, 
										telaPrincipal.btnSalvarEquipamento);
			}
		});
		
		telaPrincipal.tfe5.setVisible(true);
	}
	
	@Override 
	protected void salvarFotoCarregada() {
		DaoImagesE dao = new DaoImagesE();
		int a = dao.getIdEquipamento() - 1;
		dao.setIdEquipamento(a);
		
		dao.salvarImagem("Evidência dos danos", fis, tamanho);
	}

}
