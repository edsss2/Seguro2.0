package view.empresa;

import java.awt.event.ActionEvent;

import dao.DaoImagesE;
import view.PainelImagens;
import view.TelaPrincipal;

public class TelaFotoEquipamento2 extends TelaFoto {

	private static final long serialVersionUID = 1L;
	
	public TelaFotoEquipamento2(TelaPrincipal telaPrincipal, PainelImagens painelImagens) {
		super(telaPrincipal, "ADICIONE AS FOTOS DO EQUIPAMENTO", "2- Etiqueta", painelImagens);
	}

	@Override
	protected void acaoProsseguir(ActionEvent e) {
		dispose();
		if (telaPrincipal.tfe3 == null) {
			telaPrincipal.tfe3 = new TelaFotoEquipamento3(telaPrincipal, painelImagens);
		}
		telaPrincipal.tfe3.setVisible(true);
		
	}
	
	@Override 
	protected void salvarFotoCarregada() {
		DaoImagesE dao = new DaoImagesE();
		int a = dao.getIdEquipamento() - 1;
		dao.setIdEquipamento(a);
		
		dao.salvarImagem("etiqueta", fis, tamanho);
	}

}
