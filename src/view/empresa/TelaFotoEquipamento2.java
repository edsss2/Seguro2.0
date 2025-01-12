package view.empresa;

import java.awt.event.ActionEvent;

import dao.DaoImagesE;
<<<<<<< HEAD
=======
import view.PainelImagens;
>>>>>>> 12d6876 (Abas separadas)
import view.TelaPrincipal;

public class TelaFotoEquipamento2 extends TelaFoto {

	private static final long serialVersionUID = 1L;
	
<<<<<<< HEAD
	public TelaFotoEquipamento2(TelaPrincipal telaPrincipal) {
		super(telaPrincipal, "ADICIONE AS FOTOS DO EQUIPAMENTO", "2- Etiqueta");
=======
	public TelaFotoEquipamento2(TelaPrincipal telaPrincipal, PainelImagens painelImagens) {
		super(telaPrincipal, "ADICIONE AS FOTOS DO EQUIPAMENTO", "2- Etiqueta", painelImagens);
>>>>>>> 12d6876 (Abas separadas)
	}

	@Override
	protected void acaoProsseguir(ActionEvent e) {
		dispose();
<<<<<<< HEAD
		telaPrincipal.tfe3 = new TelaFotoEquipamento3(telaPrincipal);
=======
		telaPrincipal.tfe3 = new TelaFotoEquipamento3(telaPrincipal, painelImagens);
>>>>>>> 12d6876 (Abas separadas)
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
