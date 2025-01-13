package view;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AbstractDocument;

import Jm.JMascara;
import controle.InputFilter;
import dao.DAO;
import modelo.Assistencia;
import modelo.Endereco;
import modelo.Equipamento;
import modelo.ModeloTabela;
import modelo.Orcamento;
import modelo.Segurado;



import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import javax.swing.border.EmptyBorder;


import view.empresa.TelaFoto;
import view.empresa.TelaFoto1;
import view.empresa.TelaFoto2;
import view.empresa.TelaFoto3;
import view.empresa.TelaFoto4;
import view.empresa.TelaFoto5;
import view.empresa.TelaFotoEquipamento1;
import view.empresa.TelaFotoEquipamento2;
import view.empresa.TelaFotoEquipamento3;
import view.empresa.TelaFotoEquipamento4;
import view.empresa.TelaFotoEquipamento5;

public class TelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public int fotosAdicionadas = 0;

	public AbaEquipamento abaEquipamento;
	public AbaEmpresa abaEmpresa;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					System.out.println("oque deu errado?");
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		setResizable(false);
		setSize(new Dimension(5, 5));
		setTitle("Seguro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1184, 661);
		contentPane.add(tabbedPane);
		tabbedPane.setFont(new Font("Arial", Font.PLAIN, 18));
		
		AbaEmpresa abaEmpresa = new AbaEmpresa(TelaPrincipal.this, tabbedPane);
		//primeiro nulo é o icone, e o segundo tooltip text
		tabbedPane.addTab("Assistência e Segurado", null, abaEmpresa, null);

		abaEquipamento = new AbaEquipamento(TelaPrincipal.this);
		tabbedPane.addTab("Equipamento",null, abaEquipamento, null);
		
	}
	
	//pras duas
	public void trocarIcones(TelaFoto telaFoto, JButton botao) {
		if (telaFoto.getFoto() != null) {
			botao.setIcon(new ImageIcon(redmensionarImagem(telaFoto.getFoto())));
		}
	}
	
		abaEmpresa = new AbaEmpresa(TelaPrincipal.this, tabbedPane);
		//primeiro nulo é o icone, e o segundo tooltip text
		tabbedPane.addTab("Assistência e Segurado", null, abaEmpresa, null);

		abaEquipamento = new AbaEquipamento(TelaPrincipal.this);
		tabbedPane.addTab("Equipamento",null, abaEquipamento, null);
	}	
	
	//pras duas
	public void trocarIcones(TelaFoto telaFoto, JButton botao, int a) {
		if (telaFoto.getFoto() != null) {
			a++;
			if (a < 1) {
				botao.setIcon(new ImageIcon(redmensionarImagem(telaFoto.getFoto())));
			}

		}
	}
	
	//pras duas
	private Image redmensionarImagem(Image image) {
		Image imagemRedimensionada = image.getScaledInstance(
			    imagem1.getWidth(), 
			    imagem1.getHeight(), 

			    80, 
			    80, 
			    Image.SCALE_SMOOTH 
			);
		return imagemRedimensionada;
	}
	
	//pras duas
	public void adicionarBotoes(JPanel aba, JButton botao1, JButton botao2) {
		if(fotosAdicionadas > 0) {
			aba.add(botao1);
			aba.add(botao2);
		}

	}
	
}
