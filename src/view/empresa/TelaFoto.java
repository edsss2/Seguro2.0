package view.empresa;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

<<<<<<< HEAD
=======
import view.PainelImagens;
>>>>>>> 12d6876 (Abas separadas)
import view.TelaPrincipal;

public abstract class TelaFoto extends JFrame {

	protected static final long serialVersionUID = 1L;
	protected JPanel contentPane;
	
	protected int tamanho;
	protected static FileInputStream fis;
	
	protected JLabel lblFoto;
	protected JLabel lblDescricaoFoto;
	
	protected JButton btnProsseguir;
	protected JButton btnCarregarImagem;
	
	protected TelaPrincipal telaPrincipal;
<<<<<<< HEAD
	protected Image foto;
	
	public TelaFoto(TelaPrincipal telaPrincipal, String titulo, String descricao) {
		this.telaPrincipal = telaPrincipal;
=======
	protected PainelImagens painelImagens;
	protected Image foto;
	
	public TelaFoto(TelaPrincipal telaPrincipal, String titulo, String descricao, PainelImagens painelImagens) {
		this.telaPrincipal = telaPrincipal;
		this.painelImagens = painelImagens;
>>>>>>> 12d6876 (Abas separadas)
		
		setTitle(titulo);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 650, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblFoto = new JLabel("");
		lblFoto.setIcon(new ImageIcon("Z:\\Projetos\\seguro\\src\\img\\photo_icon.png"));
		lblFoto.setBounds(189, 87, 256, 256);
		contentPane.add(lblFoto);
		
		lblDescricaoFoto = new JLabel(descricao);
		lblDescricaoFoto.setFont(new Font("Arial", Font.PLAIN, 17));
		lblDescricaoFoto.setBounds(20, 25, 280, 35);
		contentPane.add(lblDescricaoFoto);
		
		btnProsseguir = new JButton("Prosseguir");
		btnProsseguir.addActionListener(this :: acaoProsseguir);

		btnProsseguir.setBackground(SystemColor.activeCaptionBorder);
		btnProsseguir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnProsseguir.setBounds(485, 390, 90, 35);
		contentPane.add(btnProsseguir);
		
		btnCarregarImagem = new JButton("Carregar Imagem");
		btnCarregarImagem.addActionListener(this :: acaoCarregarFoto);
		
		btnCarregarImagem.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnCarregarImagem.setBackground(Color.LIGHT_GRAY);
		btnCarregarImagem.setForeground(SystemColor.textHighlight);
		btnCarregarImagem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCarregarImagem.setBounds(345, 390, 130, 35);
		contentPane.add(btnCarregarImagem);
		
	}
	
	private void acaoCarregarFoto(ActionEvent e) {
		JFileChooser jfc = new JFileChooser();
		jfc.setDialogTitle("Selecionar arquivo");
		jfc.setFileFilter(new FileNameExtensionFilter("Arquivo de imagens(*.PNG, *.JPG, *.JPEG)", "png", "jpg", "jpeg"));
		int resultado = jfc.showOpenDialog(this);
		
		if(resultado ==JFileChooser.APPROVE_OPTION) {
<<<<<<< HEAD
			if(telaPrincipal.fotoJaFoiAdicionada1 < 1) {
				telaPrincipal.fotosAdicionadas++;
				telaPrincipal.fotoJaFoiAdicionada1++;
			}
=======
			telaPrincipal.fotosAdicionadas++;
>>>>>>> 12d6876 (Abas separadas)
			try {
				fis = new FileInputStream(jfc.getSelectedFile());
				tamanho = (int) jfc.getSelectedFile().length();
				foto = ImageIO.read(jfc.getSelectedFile()).getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(),
						Image.SCALE_SMOOTH);
				lblFoto.setIcon(new ImageIcon(foto));
				lblFoto.updateUI();
				
				salvarFotoCarregada();
			} catch (Exception a) {
				System.out.println(a);
			}
		}
		
	}

	public Image getFoto() {
		return foto;
	}
	
	protected abstract void acaoProsseguir(ActionEvent e);

    protected void salvarFotoCarregada() {


    }


	
	
}

