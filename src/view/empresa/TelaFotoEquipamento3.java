package view.empresa;

import java.awt.event.ActionEvent;

import dao.DaoImagesE;
import view.PainelImagens;
import view.TelaPrincipal;

public class TelaFotoEquipamento3 extends TelaFoto {

	private static final long serialVersionUID = 1L;
	public TelaFotoEquipamento3(TelaPrincipal telaPrincipal, PainelImagens painelImagens) {
		super(telaPrincipal, "ADICIONE AS FOTOS DO EQUIPAMENTO", "3- Verso", painelImagens);
	}

	@Override
	protected void acaoProsseguir(ActionEvent e) {
		dispose();
		telaPrincipal.tfe4 = new TelaFotoEquipamento4(telaPrincipal, painelImagens);
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
