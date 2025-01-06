package view.empresa;

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
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import dao.DaoImages;
import view.TelaPrincipal;

import java.awt.Color;

public class TelaFoto3 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private int tamanho;
	private FileInputStream fis;
	
	private JLabel lblFoto;
	private JLabel lblDescricaoFoto;
	
	private JButton btnProsseguir;
	private JButton btnCarregarImagem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFoto1 frame = new TelaFoto1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	
	public TelaFoto3() {
		setTitle("ADICIONE AS FOTOS DA RESIDÊNCIA");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblFoto = new JLabel("");
		lblFoto.setIcon(new ImageIcon("Z:\\Projetos\\seguro\\src\\img\\9004666_image_photo_picture_gallery_file_icon.png"));
		lblFoto.setBounds(189, 87, 256, 256);
		contentPane.add(lblFoto);
		
		lblDescricaoFoto = new JLabel("3- Medidor de Energia");
		lblDescricaoFoto.setFont(new Font("Arial", Font.PLAIN, 17));
		lblDescricaoFoto.setBounds(20, 25, 280, 35);
		contentPane.add(lblDescricaoFoto);
		
		btnProsseguir = new JButton("Prosseguir");
		btnProsseguir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				TelaFoto4 novaTela = new TelaFoto4();	
				novaTela.setVisible(true);
				
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
				
				dao.salvarImagem("medidor", fis, tamanho);

			}
		});
		btnCarregarImagem.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnCarregarImagem.setBackground(Color.LIGHT_GRAY);
		btnCarregarImagem.setForeground(SystemColor.textHighlight);
		btnCarregarImagem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCarregarImagem.setBounds(345, 390, 130, 35);
		contentPane.add(btnCarregarImagem);
		
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
