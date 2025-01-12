package view.empresa;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import dao.DaoImages;
<<<<<<< HEAD
=======
import view.PainelImagens;
>>>>>>> 12d6876 (Abas separadas)
import view.TelaPrincipal;

public class TelaFoto5 extends TelaFoto {

	private static final long serialVersionUID = 1L;

<<<<<<< HEAD
	public TelaFoto5(TelaPrincipal telaPrincipal) {
		super(telaPrincipal, "ADICIONE AS FOTOS DA RESIDÊNCIA", "5- Localização fixa");
=======
	public TelaFoto5(TelaPrincipal telaPrincipal, PainelImagens painelImagens) {
		super(telaPrincipal, "ADICIONE AS FOTOS DA RESIDÊNCIA", "5- Localização fixa", painelImagens);
>>>>>>> 12d6876 (Abas separadas)
	}
	
	protected void verificaAsFotos() {
		String mensagem = telaPrincipal.fotosAdicionadas + " Fotos foram adicionadas";
		String mensagem1 = telaPrincipal.fotosAdicionadas + " Foto foi adicionada";
		String mensagemErro ="Nenhuma foto foi adicionada";
		
		if (telaPrincipal.fotosAdicionadas > 1) {
			JOptionPane.showMessageDialog(TelaFoto5.this, mensagem, "Notificação", JOptionPane.INFORMATION_MESSAGE);			
		}else if(telaPrincipal.fotosAdicionadas == 1) {
			JOptionPane.showMessageDialog(TelaFoto5.this, mensagem1, "Notificação", JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(TelaFoto5.this, mensagemErro, "Erro", JOptionPane.ERROR_MESSAGE);
<<<<<<< HEAD
			telaPrincipal.telaFoto1 = new TelaFoto1(telaPrincipal);
			telaPrincipal.telaFoto1.setVisible(true);
=======
			telaPrincipal.tf1 = new TelaFoto1(telaPrincipal, painelImagens);
			telaPrincipal.tf1.setVisible(true);
>>>>>>> 12d6876 (Abas separadas)
		}
		
	}
	
	@Override
	protected void acaoProsseguir(ActionEvent e) {
		dispose();
		verificaAsFotos();
	}
	
	@Override
	protected void salvarFotoCarregada() {
		DaoImages dao = new DaoImages();
		int a = dao.getIdEmpresa() - 1;
		dao.setIdEmpresa(a);

		dao.salvarImagem("localizacao", fis, tamanho);
	}

}