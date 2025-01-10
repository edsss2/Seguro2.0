package view.empresa;

import java.awt.event.ActionEvent;

import dao.DaoImages;
import view.TelaPrincipal;

public class TelaFoto4 extends TelaFoto {

	private static final long serialVersionUID = 1L;

	public TelaFoto4(TelaPrincipal telaPrincipal) {
		super(telaPrincipal, "ADICIONE AS FOTOS DA RESIDÊNCIA", "4- Quadro de Dijuntores");
	}

	@Override
	protected void acaoProsseguir(ActionEvent e) {
		dispose();
					
		telaPrincipal.tf5 = new TelaFoto5(telaPrincipal);
		telaPrincipal.telaFoto5.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosed(java.awt.event.WindowEvent e) {
			            	
				telaPrincipal.trocarIcones(telaPrincipal.tfe1, telaPrincipal.equImagem1);
				telaPrincipal.trocarIcones(telaPrincipal.tfe2, telaPrincipal.equImagem2);
				telaPrincipal.trocarIcones(telaPrincipal.tfe3, telaPrincipal.equImagem3);
				telaPrincipal.trocarIcones(telaPrincipal.tfe4, telaPrincipal.equImagem4);
				telaPrincipal.trocarIcones(telaPrincipal.tfe5, telaPrincipal.equImagem5);
				
			    telaPrincipal.adicionarBotoes(telaPrincipal.abaEmpresa,
			                                        telaPrincipal.btnSalvar, 
			                                        telaPrincipal.btnProsseguir);
			    telaPrincipal.repaint();
			}
		});				
		telaPrincipal.telaFoto5.setVisible(true);
	}

		@Override 
		protected void salvarFotoCarregada() {
			DaoImages dao = new DaoImages();
			int a = dao.getIdEmpresa() - 1;
			dao.setIdEmpresa(a);

			dao.salvarImagem("quadro_dijuntores", fis, tamanho);
		}
			
}