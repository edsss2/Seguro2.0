package view;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import view.empresa.TelaFoto;

public class PainelImagens extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public JButton imagem1, imagem2, imagem3, imagem4, imagem5;
	
	private void mostrarTela(ActionEvent e, TelaFoto tf) {
		tf.setVisible(true);
	}

	/**
	 * Create the panel.
	 */
	public PainelImagens(TelaFoto tf1, TelaFoto tf2, TelaFoto tf3, TelaFoto tf4, TelaFoto tf5) {
		
		setLayout(null);

		imagem1 = new JButton("");
		imagem1.addActionListener(e -> mostrarTela(e, tf1));
		imagem1.setIcon(new ImageIcon("Z:\\Projetos\\seguro\\src\\img\\icons8-imagem-64.png"));
		imagem1.setBounds(0, 0, 80, 80);
		add(imagem1);
		
		imagem2 = new JButton("");
		imagem2.addActionListener(e -> mostrarTela(e, tf2));
		imagem2.setIcon(new ImageIcon("Z:\\Projetos\\seguro\\src\\img\\icons8-imagem-64.png"));
		imagem2.setBounds(80, 0, 80, 80);
		add(imagem2);
		
		imagem3 = new JButton("");
		imagem3.addActionListener(e -> mostrarTela(e, tf4));
		imagem3.setIcon(new ImageIcon("Z:\\Projetos\\seguro\\src\\img\\icons8-imagem-64.png"));
		imagem3.setBounds(160, 0, 80, 80);
		add(imagem3);
		
		imagem4 = new JButton("");
		imagem4.addActionListener(e -> mostrarTela(e, tf4));
		imagem4.setIcon(new ImageIcon("Z:\\Projetos\\seguro\\src\\img\\icons8-imagem-64.png"));
		imagem4.setBounds(240, 0, 80, 80);
		add(imagem4);
		
		imagem5 = new JButton("");
		imagem5.addActionListener(e -> mostrarTela(e, tf5));
		imagem5.setIcon(new ImageIcon("Z:\\Projetos\\seguro\\src\\img\\icons8-imagem-64.png"));
		imagem5.setBounds(320, 0, 80, 80);
		add(imagem5);
		
	}
}
