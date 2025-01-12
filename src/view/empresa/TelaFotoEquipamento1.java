package view.empresa;

import java.awt.event.ActionEvent;

import dao.DaoImagesE;
<<<<<<< HEAD
=======
import view.PainelImagens;
>>>>>>> 12d6876 (Abas separadas)
import view.TelaPrincipal;

public class TelaFotoEquipamento1 extends TelaFoto{
	private static final long serialVersionUID = 1L;

<<<<<<< HEAD
	public TelaFotoEquipamento1(TelaPrincipal telaPrincipal) {
		super(telaPrincipal, "ADICIONE AS FOTOS DO EQUIPAMENTO", "1- Frente");
=======
	public TelaFotoEquipamento1(TelaPrincipal telaPrincipal, PainelImagens painelImagens) {
		super(telaPrincipal, "ADICIONE AS FOTOS DO EQUIPAMENTO", "1- Frente", painelImagens);
>>>>>>> 12d6876 (Abas separadas)
	}


	@Override
	protected void acaoProsseguir(ActionEvent e) {
		dispose();
<<<<<<< HEAD
		telaPrincipal.tfe2 = new TelaFotoEquipamento2(telaPrincipal);
=======
		telaPrincipal.tfe2 = new TelaFotoEquipamento2(telaPrincipal, painelImagens);
>>>>>>> 12d6876 (Abas separadas)
		telaPrincipal.tfe2.setVisible(true);
		
	}
	
	@Override 
	protected void salvarFotoCarregada() {
		DaoImagesE dao = new DaoImagesE();
		dao.criarEquipamento();

		dao.salvarImagem("frente", fis, tamanho);
	}

}
