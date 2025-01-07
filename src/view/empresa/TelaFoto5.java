package view.empresa;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import dao.DaoImages;
import view.TelaPrincipal;

public class TelaFoto5 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private int tamanho;
	private FileInputStream fis;
	
	private JLabel lblFoto;
	private JLabel lblDescricaoFoto;
	
	private JButton btnProsseguir;
	private JButton btnCarregarImagem;
	
	private TelaPrincipal telaPrincipal;

	public TelaFoto5(TelaPrincipal telaPrincipal) {
		this.telaPrincipal = telaPrincipal;
		
		setTitle("ADICIONE AS FOTOS DA RESIDÊNCIA");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblFoto = new JLabel("");
		lblFoto.setIcon(new ImageIcon("Z:\\Projetos\\seguro\\src\\img\\photo_icon.png"));
		lblFoto.setBounds(189, 87, 256, 256);
		contentPane.add(lblFoto);
		
		lblDescricaoFoto = new JLabel("5- Localização fixa");
		lblDescricaoFoto.setFont(new Font("Arial", Font.PLAIN, 17));
		lblDescricaoFoto.setBounds(20, 25, 280, 35);
		contentPane.add(lblDescricaoFoto);
		
		btnProsseguir = new JButton("Prosseguir");
		btnProsseguir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				verificaAsFotos();
				
				dispose();
			}
		});
		btnProsseguir.setBackground(SystemColor.activeCaptionBorder);
		btnProsseguir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnProsseguir.setBounds(485, 390, 90, 35);
		contentPane.add(btnProsseguir);
		
		btnCarregarImagem = new JButton("Carregar Imagem");
		btnCarregarImagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carregarFoto();
				
				DaoImages dao = new DaoImages();
				int a = dao.getIdEmpresa() - 1;
				dao.setIdEmpresa(a);

				dao.salvarImagem("localizacao", fis, tamanho);

			}
		});
		btnCarregarImagem.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnCarregarImagem.setBackground(Color.LIGHT_GRAY);
		btnCarregarImagem.setForeground(SystemColor.textHighlight);
		btnCarregarImagem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCarregarImagem.setBounds(345, 390, 130, 35);
		contentPane.add(btnCarregarImagem);
		
	}
	
	private void verificaAsFotos() {
		String mensagem = TelaPrincipal.fotosAdicionadas + " Fotos foram adicionadas";
		String mensagem1 = TelaPrincipal.fotosAdicionadas + " Foto foi adicionada";
		String mensagemErro ="Nenhuma foto foi adicionada";
		
		if (TelaPrincipal.fotosAdicionadas > 1) {
			JOptionPane.showMessageDialog(TelaFoto5.this, mensagem, "Notificação", JOptionPane.INFORMATION_MESSAGE);			
		}else if(TelaPrincipal.fotosAdicionadas == 1) {
			JOptionPane.showMessageDialog(TelaFoto5.this, mensagem1, "Notificação", JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(TelaFoto5.this, mensagemErro, "Erro", JOptionPane.ERROR_MESSAGE);
			telaPrincipal.telaFoto1 = new TelaFoto1(telaPrincipal);
			telaPrincipal.telaFoto1.setVisible(true);
		}
		
	}
	
	private void carregarFoto() {
		JFileChooser jfc = new JFileChooser();
		jfc.setDialogTitle("Selecionar arquivo");
		jfc.setFileFilter(new FileNameExtensionFilter("Arquivo de imagens(*.PNG, *.JPG, *.JPEG)", "png", "jpg", "jpeg"));
		int resultado = jfc.showOpenDialog(this);
		
		if(resultado ==JFileChooser.APPROVE_OPTION) {
			TelaPrincipal.fotosAdicionadas++;
			try {
				fis = new FileInputStream(jfc.getSelectedFile());
				tamanho = (int) jfc.getSelectedFile().length();
				Image foto = ImageIO.read(jfc.getSelectedFile()).getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(),
						Image.SCALE_SMOOTH);
				lblFoto.setIcon(new ImageIcon(foto));
				lblFoto.updateUI();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
	}
	
}