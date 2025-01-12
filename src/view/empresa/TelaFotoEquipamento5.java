package view.empresa;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import dao.DaoImagesE;
<<<<<<< HEAD
=======
import view.PainelImagens;
>>>>>>> 12d6876 (Abas separadas)
import view.TelaPrincipal;

public class TelaFotoEquipamento5 extends TelaFoto {

	private static final long serialVersionUID = 1L;

<<<<<<< HEAD
	public TelaFotoEquipamento5(TelaPrincipal telaPrincipal) {
		super(telaPrincipal, "ADICIONE AS FOTOS DO EQUIPAMENTO", "5- Local de Instalação");
=======
	public TelaFotoEquipamento5(TelaPrincipal telaPrincipal, PainelImagens painelImagens) {
		super(telaPrincipal, "ADICIONE AS FOTOS DO EQUIPAMENTO", "5- Local de Instalação", painelImagens);
>>>>>>> 12d6876 (Abas separadas)
	}

	
	@Override
	protected void acaoProsseguir(ActionEvent e) {
		dispose();
		verificaAsFotos();
		

	}
	
	protected void verificaAsFotos() {
		String mensagem = telaPrincipal.fotosAdicionadas + " Fotos foram adicionadas";
		String mensagem1 = telaPrincipal.fotosAdicionadas + " Foto foi adicionada";
		String mensagemErro ="Nenhuma foto foi adicionada";
		
		if (telaPrincipal.fotosAdicionadas > 1) {
			JOptionPane.showMessageDialog(TelaFotoEquipamento5.this, mensagem, "Notificação", JOptionPane.INFORMATION_MESSAGE);			
		}else if(telaPrincipal.fotosAdicionadas == 1) {
			JOptionPane.showMessageDialog(TelaFotoEquipamento5.this, mensagem1, "Notificação", JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(TelaFotoEquipamento5.this, mensagemErro, "Erro", JOptionPane.ERROR_MESSAGE);
<<<<<<< HEAD
			telaPrincipal.tfe1 = new TelaFotoEquipamento1(telaPrincipal);
=======
			telaPrincipal.tfe1 = new TelaFotoEquipamento1(telaPrincipal, painelImagens);
>>>>>>> 12d6876 (Abas separadas)
			telaPrincipal.tfe1.setVisible(true);
		}
		
	}
	
	@Override
	protected void salvarFotoCarregada() {
		DaoImagesE dao = new DaoImagesE();
		int a = dao.getIdEquipamento() - 1;
		dao.setIdEquipamento(a);
		dao.salvarImagem("local_instalacao", fis, tamanho);
	}

}
