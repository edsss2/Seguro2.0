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
					
		telaPrincipal.telaFoto5 = new TelaFoto5(telaPrincipal);
		telaPrincipal.telaFoto5.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosed(java.awt.event.WindowEvent e) {
			            	
				telaPrincipal.trocarIcones();	//troca os icones da telaPrincipal pelas fotos
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