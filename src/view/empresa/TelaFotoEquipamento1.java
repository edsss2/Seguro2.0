package view.empresa;

import java.awt.event.ActionEvent;

import dao.DaoImagesE;
import view.PainelImagens;
import view.TelaPrincipal;

public class TelaFotoEquipamento1 extends TelaFoto{
	private static final long serialVersionUID = 1L;

	public TelaFotoEquipamento1(TelaPrincipal telaPrincipal, PainelImagens painelImagens) {
		super(telaPrincipal, "ADICIONE AS FOTOS DO EQUIPAMENTO", "1- Frente", painelImagens);
	}


	@Override
	protected void acaoProsseguir(ActionEvent e) {
		dispose();
		if (telaPrincipal.tfe2 == null) {
			telaPrincipal.tfe2 = new TelaFotoEquipamento2(telaPrincipal, painelImagens);
		}
		telaPrincipal.tfe2.setVisible(true);
		
	}
	
	@Override 
	protected void salvarFotoCarregada() {
		DaoImagesE dao = new DaoImagesE();
		dao.criarEquipamento();

		dao.salvarImagem("frente", fis, tamanho);
	}

}
