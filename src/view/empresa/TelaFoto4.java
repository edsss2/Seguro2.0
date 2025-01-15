package view.empresa;

import java.awt.event.ActionEvent;

import dao.DaoImages;
import view.PainelImagens;
import view.TelaPrincipal;

public class TelaFoto4 extends TelaFoto {

	private static final long serialVersionUID = 1L;
	
	public TelaFoto4(TelaPrincipal telaPrincipal, PainelImagens painelImagens) {
		super(telaPrincipal, "ADICIONE AS FOTOS DA RESIDÊNCIA", "4- Quadro de Dijuntores", painelImagens);
	}

	@Override
	protected void acaoProsseguir(ActionEvent e) {
		dispose();
		
		if (telaPrincipal.tf5 == null) {
			telaPrincipal.tf5 = new TelaFoto5(telaPrincipal, painelImagens);
		}
		telaPrincipal.tf5.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosed(java.awt.event.WindowEvent e) {
			            	
				telaPrincipal.trocarIcones(telaPrincipal.tf1, painelImagens.imagem1);
				telaPrincipal.trocarIcones(telaPrincipal.tf2, painelImagens.imagem2);
				telaPrincipal.trocarIcones(telaPrincipal.tf3, painelImagens.imagem3);
				telaPrincipal.trocarIcones(telaPrincipal.tf4, painelImagens.imagem4);
				telaPrincipal.trocarIcones(telaPrincipal.tf5, painelImagens.imagem5);
				
			    telaPrincipal.adicionarBotoes(telaPrincipal.abaEmpresa,
			                                        telaPrincipal.abaEmpresa.btnSalvar, 
			                                        telaPrincipal.abaEmpresa.btnProsseguir);
			    telaPrincipal.repaint();
			}
		});				
		telaPrincipal.tf5.setVisible(true);
	}

		@Override 
		protected void salvarFotoCarregada() {
			DaoImages dao = new DaoImages();
			int a = dao.getIdEmpresa() - 1;
			dao.setIdEmpresa(a);

			dao.salvarImagem("quadro_dijuntores", fis, tamanho);
		}
			
}