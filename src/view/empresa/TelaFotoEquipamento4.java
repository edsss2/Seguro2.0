package view.empresa;

import java.awt.event.ActionEvent;

import dao.DaoImagesE;
import view.TelaPrincipal;

public class TelaFotoEquipamento4 extends TelaFoto {

	private static final long serialVersionUID = 1L;
	private int fotoAdd1 = 0, fotoAdd2 = 0, fotoAdd3 = 0, fotoAdd4 = 0, fotoAdd5 = 0;
	
	public TelaFotoEquipamento4(TelaPrincipal telaPrincipal, PainelImagens painelImagens) {
		super(telaPrincipal, "ADICIONE AS FOTOS DO EQUIPAMENTO", "4- Evidências dos danos", painelImagens);
	}

	@Override
	protected void acaoProsseguir(ActionEvent e) {
		dispose();
		

		telaPrincipal.tfe5 = new TelaFotoEquipamento5(telaPrincipal, painelImagens);
		telaPrincipal.tfe5.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosed(java.awt.event.WindowEvent e) {

				telaPrincipal.trocarIcones(telaPrincipal.tfe1, painelImagens.imagem1, fotoAdd1);
				telaPrincipal.trocarIcones(telaPrincipal.tfe2, painelImagens.imagem2, fotoAdd2);
				telaPrincipal.trocarIcones(telaPrincipal.tfe3, painelImagens.imagem3, fotoAdd3);
				telaPrincipal.trocarIcones(telaPrincipal.tfe4, painelImagens.imagem4, fotoAdd4);
				telaPrincipal.trocarIcones(telaPrincipal.tfe5, painelImagens.imagem5, fotoAdd5);
		
				telaPrincipal.adicionarBotoes(telaPrincipal.abaEquipamento, 
										telaPrincipal.abaEquipamento.btnProsseguirEquipamento, 
										telaPrincipal.abaEquipamento.btnSalvarEquipamento);
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
