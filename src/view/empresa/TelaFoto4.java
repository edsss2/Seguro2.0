package view.empresa;

import java.awt.event.ActionEvent;
import view.PainelImagens;
import view.TelaPrincipal;

public class TelaFoto4 extends TelaFoto {

	private static final long serialVersionUID = 1L;
	
	private int fotoAdd1 = 0, fotoAdd2 = 0, fotoAdd3 = 0, fotoAdd4 = 0, fotoAdd5 = 0;

	public TelaFoto4(TelaPrincipal telaPrincipal, PainelImagens painelImagens) {
		super(telaPrincipal, "ADICIONE AS FOTOS DA RESIDÊNCIA", "4- Quadro de Dijuntores", painelImagens);
	}

	@Override
	protected void acaoProsseguir(ActionEvent e) {
		dispose();
					
		telaPrincipal.tf5 = new TelaFoto5(telaPrincipal, painelImagens);
		telaPrincipal.tf5.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosed(java.awt.event.WindowEvent e) {
			            	
				telaPrincipal.trocarIcones(telaPrincipal.tfe1, painelImagens.imagem1, fotoAdd1);
				telaPrincipal.trocarIcones(telaPrincipal.tfe2, painelImagens.imagem2, fotoAdd2);
				telaPrincipal.trocarIcones(telaPrincipal.tfe3, painelImagens.imagem3, fotoAdd3);
				telaPrincipal.trocarIcones(telaPrincipal.tfe4, painelImagens.imagem4, fotoAdd4);
				telaPrincipal.trocarIcones(telaPrincipal.tfe5, painelImagens.imagem5, fotoAdd5);
				
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