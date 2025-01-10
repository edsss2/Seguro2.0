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
	private JTextField txtCnpj;
	private JTextField txtNome;
	private JTextField txtTelefone;	
	private JTextField txtRua;
	private JTextField txtBairro;
	private JTextField txtNumero;
	private JTextField txtCidade;
	private JTextField txtEstado;
	private JTextField txtCep;
	private JTextField txtTecnico;
	private JTextField txtSeguradoCep;
	
	private int cep;
	private int seguradoCep;
	private long telefone;
	
	//Endereço do segurado
	private JTextField txtSeguradoRua;
	private JTextField txtSeguradoBairro;
	private JTextField txtSeguradoNumero;
	private JTextField txtSeguradoCidade;
	private JTextField txtSeguradoEstado;
	private JTextField txtSeguradoNome;
	
	
	Endereco enderecoAssistencia = new Endereco();
	Endereco enderecoSegurado = new Endereco();
	Assistencia assistencia = new Assistencia();
	Segurado segurado = new Segurado();
	
	//Equipamento
	private ArrayList<Orcamento> orcamentos;
	Equipamento equipamento = new Equipamento();
	
	private JTextField txtNomeEquipamento;
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JTextField txtNumeroSerie;
	private String possibilidadeReparo;
	private JTable table;
	
	public int fotosAdicionadas = 0;
	public int fotoJaFoiAdicionada1 = 0;
	public int fotoJaFoiAdicionada2 = 0;
	public int fotoJaFoiAdicionada3 = 0;
	public int fotoJaFoiAdicionada4 = 0;
	public int fotoJaFoiAdicionada5 = 0;
	
	
	public TelaFoto1 telaFoto1;
	public TelaFoto2 telaFoto2;
	public TelaFoto3 telaFoto3;
	public TelaFoto4 telaFoto4;
	public TelaFoto5 telaFoto5;
	public TelaFotoEquipamento1 tfe1;
	public TelaFotoEquipamento2 tfe2;
	public TelaFotoEquipamento3 tfe3;
	public TelaFotoEquipamento4 tfe4;
	public TelaFotoEquipamento5 tfe5;
	
	
	private JButton imagem1;
	private JButton imagem2;
	private JButton imagem3;
	private JButton imagem4;
	private JButton imagem5;
	
	public JButton equImagem1;
	public JButton equImagem2;
	public JButton equImagem3;
	public JButton equImagem4;
	public JButton equImagem5;
	
	public JButton btnSalvar;
	public JButton btnProsseguir;
	public JButton btnSalvarEquipamento;
	public JButton btnProsseguirEquipamento;
	private JButton btnAddFotoEquipamento;
	public JPanel abaEmpresa;
	public JPanel abaEquipamento;
	
	
	

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

		
		//aba Equipamento
		
		abaEquipamento = new JPanel();
		tabbedPane.addTab("Equipamento", null, abaEquipamento, null);
		abaEquipamento.setLayout(null);
		
		JLabel lblDadosEquipamento = new JLabel("DADOS DO EQUIPAMENTO");
		lblDadosEquipamento.setFont(new Font("Arial Black", Font.PLAIN, 17));
		lblDadosEquipamento.setBounds(22, 10, 350, 55);
		abaEquipamento.add(lblDadosEquipamento);
		
		JLabel lblNomeEquipamento = new JLabel("Nome do Equipamento:");
		lblNomeEquipamento.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNomeEquipamento.setBounds(22, 60, 158, 30);
		abaEquipamento.add(lblNomeEquipamento);
		
		txtNomeEquipamento = new JTextField();
		txtNomeEquipamento.setBounds(175, 60, 255, 26);
		abaEquipamento.add(txtNomeEquipamento);
		txtNomeEquipamento.setColumns(10);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Arial", Font.PLAIN, 14));
		lblMarca.setBounds(22, 100, 49, 30);
		abaEquipamento.add(lblMarca);
		
		txtMarca = new JTextField();
		txtMarca.setBounds(81, 100, 180, 26);
		abaEquipamento.add(txtMarca);
		txtMarca.setColumns(10);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setFont(new Font("Arial", Font.PLAIN, 14));
		lblModelo.setBounds(22, 140, 55, 30);
		abaEquipamento.add(lblModelo);
		
		txtModelo = new JTextField();
		txtModelo.setBounds(81, 140, 180, 26);
		abaEquipamento.add(txtModelo);
		txtModelo.setColumns(10);
		
		JLabel lblNumeroSerie = new JLabel("Número de série:");
		lblNumeroSerie.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNumeroSerie.setBounds(22, 180, 114, 30);
		abaEquipamento.add(lblNumeroSerie);
		
		txtNumeroSerie = new JTextField();
		txtNumeroSerie.setBounds(136, 180, 180, 26);
		abaEquipamento.add(txtNumeroSerie);
		txtNumeroSerie.setColumns(10);
		
		JLabel lblPossibilidadeReparo = new JLabel("Há possibilidade de reparo do equipamento?");
		lblPossibilidadeReparo.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblPossibilidadeReparo.setBounds(22, 220, 340, 30);
		abaEquipamento.add(lblPossibilidadeReparo);
		
		JCheckBox jCheckBoxPossibilidadeReparo = new JCheckBox("Sim");
		jCheckBoxPossibilidadeReparo.setFont(new Font("Arial", Font.PLAIN, 14));
		jCheckBoxPossibilidadeReparo.setBounds(22, 250, 50, 23);
		abaEquipamento.add(jCheckBoxPossibilidadeReparo);
		
		JLabel lblComponentesDanificados = new JLabel("Componentes(peças)  danificados nos equipamentos:");
		lblComponentesDanificados.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblComponentesDanificados.setBounds(22, 380, 400, 30);
		abaEquipamento.add(lblComponentesDanificados);
		
		JEditorPane txtEditPecasDanificadas = new JEditorPane();
		txtEditPecasDanificadas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEditPecasDanificadas.setBorder(UIManager.getBorder("DesktopIcon.border"));
		txtEditPecasDanificadas.setText("Nome dos Componentes/peças danificados");
		txtEditPecasDanificadas.setBounds(22, 410, 450, 60);
		abaEquipamento.add(txtEditPecasDanificadas);
		
		JLabel lblMotivoDano = new JLabel("Causa conclusiva do dano na peça/ componentes (motivo do dano):");
		lblMotivoDano.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblMotivoDano.setBounds(22, 280, 558, 30);
		abaEquipamento.add(lblMotivoDano);
		
		JEditorPane txtEditMotivoDano = new JEditorPane();
		txtEditMotivoDano.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEditMotivoDano.setBorder(UIManager.getBorder("DesktopIcon.border"));
		txtEditMotivoDano.setText("Causa do dano após avaliação do técnico");
		txtEditMotivoDano.setBounds(22, 310, 450, 60);
		abaEquipamento.add(txtEditMotivoDano);
		
		JLabel lblPt = new JLabel("Se for perda total do equipamento, qual o motivo da perda total do equipamento?");
		lblPt.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblPt.setBounds(22, 480, 600, 30);
		abaEquipamento.add(lblPt);
		
		JEditorPane txtEditPt = new JEditorPane();
		txtEditPt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEditPt.setBorder(UIManager.getBorder("DesktopIcon.border"));
		txtEditPt.setText("Causa do dano após avaliação do técnico");
		txtEditPt.setBounds(22, 510, 450, 60);
		abaEquipamento.add(txtEditPt);
		
		
		//Orcamento
		
		JLabel lblOrcamento = new JLabel("ORÇAMENTO DE REPARO DO EQUIPAMENTO");
		lblOrcamento.setFont(new Font("Arial Black", Font.PLAIN, 17));
		lblOrcamento.setBounds(622, 10, 427, 55);
		abaEquipamento.add(lblOrcamento);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(622, 60, 480, 200);
		abaEquipamento.add(scrollPane);
		
		orcamentos = new ArrayList<>();
		ModeloTabela modeloTabela = new ModeloTabela(orcamentos);
		table = new JTable();
		
		table.setModel(modeloTabela);
		table.getColumnModel().getColumn(1).setMaxWidth(90);;
        table.getColumnModel().getColumn(1).setPreferredWidth(80);
        table.getColumnModel().getColumn(1).setMinWidth(70);       
        table.setFont(new Font("Tahoma", Font.PLAIN, 12));

        
        table.setRowHeight(25); 
        
		scrollPane.setViewportView(table);
		
		JButton btnAdicionarLinha = new JButton("Adicionar Linha");
		btnAdicionarLinha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modeloTabela.addRow(new Orcamento(" ", 0.0)); 
			}
		});
		
		btnAdicionarLinha.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		btnAdicionarLinha.setBorder(UIManager.getBorder("DesktopIcon.border"));
		btnAdicionarLinha.setBackground(Color.LIGHT_GRAY);
		btnAdicionarLinha.setBounds(622, 270, 120, 35);
		abaEquipamento.add(btnAdicionarLinha);

		JButton btnRemoverLinha = new JButton("Remover Linha");
		btnRemoverLinha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = table.getSelectedRow();
	            if (linhaSelecionada != -1) {
	                modeloTabela.removeRow(linhaSelecionada);
	            } else {
	                JOptionPane.showMessageDialog(abaEquipamento, "Selecione uma linha para remover.");
	            }
			}
		});
		
		btnRemoverLinha.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		btnRemoverLinha.setBorder(UIManager.getBorder("DesktopIcon.border"));
		btnRemoverLinha.setBackground(Color.LIGHT_GRAY);
		btnRemoverLinha.setBounds(772, 270, 120, 35);
		abaEquipamento.add(btnRemoverLinha);
		
		
		btnSalvarEquipamento = new JButton("Salvar");
		btnSalvarEquipamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//If para resgatar o checkBox
				if (jCheckBoxPossibilidadeReparo.isSelected()) {
					possibilidadeReparo = "Sim";
				} else {
					possibilidadeReparo = "Não";
				}

				DAO dao = new DAO();
				
				equipamento = new Equipamento(
						txtNomeEquipamento.getText(),
						txtMarca.getText(),
						txtModelo.getText(),
						txtNumeroSerie.getText(),
						txtEditPecasDanificadas.getText(),
						txtEditMotivoDano.getText(),
						possibilidadeReparo,
						txtEditPt.getText()
						);
				
				dao.salvarEquipamento(equipamento);
				int idEquipamento = resgatarId(equipamento);
				salvarTabelaOrcamento(dao, idEquipamento);

				int idEnderecoAssistencia = resgatarId(enderecoAssistencia);
				dao.salvarEndereco(enderecoSegurado);
				int idEnderecoSegurado = resgatarId(enderecoSegurado);
				dao.salvarAssistencia(assistencia, idEnderecoAssistencia);
				dao.salvarSegurado(segurado, idEnderecoSegurado);
				
				JOptionPane.showMessageDialog(null, "Salvo com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		
		btnSalvarEquipamento.setBackground(Color.LIGHT_GRAY);
		btnSalvarEquipamento.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		btnSalvarEquipamento.setBounds(870, 500, 100, 35);
		
		btnProsseguirEquipamento = new JButton("Prosseguir");
		btnProsseguirEquipamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnProsseguirEquipamento.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		btnProsseguirEquipamento.setBackground(Color.LIGHT_GRAY);
		btnProsseguirEquipamento.setBounds(990, 500, 100, 35);
		
		btnAddFotoEquipamento = new JButton("Adicionar fotos");
		btnAddFotoEquipamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfe1 = new TelaFotoEquipamento1(TelaPrincipal.this);
				tfe1.setVisible(true);
				
			}
		});
		btnAddFotoEquipamento.setBackground(Color.LIGHT_GRAY);
		btnAddFotoEquipamento.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		btnAddFotoEquipamento.setBounds(720, 500, 130, 35);
		abaEquipamento.add(btnAddFotoEquipamento);
		
		JLabel lblImagensEquipamento = new JLabel("Imagens:");
		lblImagensEquipamento.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblImagensEquipamento.setBounds(622, 335, 100, 35);
		abaEquipamento.add(lblImagensEquipamento);
		
		JPanel painelImagensEquipamento = new JPanel();
		painelImagensEquipamento.setBounds(622, 370, 420, 90);
		abaEquipamento.add(painelImagensEquipamento);
		painelImagensEquipamento.setLayout(null);
		
		equImagem1 = new JButton("");
		equImagem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfe1.setVisible(true);
			}
		});
		equImagem1.setIcon(new ImageIcon("Z:\\Projetos\\seguro\\src\\img\\icons8-imagem-64.png"));
		equImagem1.setBounds(0, 0, 80, 80);
		painelImagensEquipamento.add(equImagem1);
		
		equImagem2 = new JButton("");
		equImagem2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfe2.setVisible(true);
			}
		});
		equImagem2.setIcon(new ImageIcon("Z:\\Projetos\\seguro\\src\\img\\icons8-imagem-64.png"));
		equImagem2.setBounds(80, 0, 80, 80);
		painelImagensEquipamento.add(equImagem2);
		
		equImagem3 = new JButton("");
		equImagem3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfe3.setVisible(true);
			}
		});
		equImagem3.setIcon(new ImageIcon("Z:\\Projetos\\seguro\\src\\img\\icons8-imagem-64.png"));
		equImagem3.setBounds(160, 0, 80, 80);
		painelImagensEquipamento.add(equImagem3);
		
		equImagem4 = new JButton("");
		equImagem4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfe4.setVisible(true);
			}
		});
		equImagem4.setIcon(new ImageIcon("Z:\\Projetos\\seguro\\src\\img\\icons8-imagem-64.png"));
		equImagem4.setBounds(240, 0, 80, 80);
		painelImagensEquipamento.add(equImagem4);
		
		equImagem5 = new JButton("");
		equImagem5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfe5.setVisible(true);
			}
		});
		equImagem5.setIcon(new ImageIcon("Z:\\Projetos\\seguro\\src\\img\\icons8-imagem-64.png"));
		equImagem5.setBounds(320, 0, 80, 80);
		painelImagensEquipamento.add(equImagem5);

	
		
	}

	//abaEmpresa
	private void criarInstancias() {
	    try {
	        // Valida e obtém os valores digitados pelo usuário
	        int numero = Integer.parseInt(txtNumero.getText());
	        int numeroSegurado = Integer.parseInt(txtSeguradoNumero.getText());
	        cep = Integer.parseInt(JMascara.GetJmascaraLimpar(txtCep.getText()));
	        seguradoCep = Integer.parseInt(JMascara.GetJmascaraLimpar(txtSeguradoCep.getText()));
	        telefone = Long.parseLong(JMascara.GetJmascaraLimpar(txtTelefone.getText()));

	        // Instancia objetos após validação
	        enderecoAssistencia = new Endereco(
	            txtRua.getText(),
	            numero,
	            txtBairro.getText(),
	            txtCidade.getText(),
	            txtEstado.getText(),
	            cep
	        );

	        enderecoSegurado = new Endereco(
	            txtSeguradoRua.getText(),
	            numeroSegurado,
	            txtSeguradoBairro.getText(),
	            txtSeguradoCidade.getText(),
	            txtSeguradoEstado.getText(),
	            seguradoCep
	        );

	        assistencia = new Assistencia(
	            txtNome.getText(),
	            JMascara.GetJmascaraLimpar(txtCnpj.getText()),
	            telefone,
	            txtCep.getText()
	        );

	        segurado = new Segurado(txtSeguradoNome.getText());
			
	    } catch (NumberFormatException e) {
	        // Exibe mensagem ao usuário sobre dados inválidos
	        JOptionPane.showMessageDialog(this, "Preencha todos os campos corretamente!", "Erro", JOptionPane.ERROR_MESSAGE);
	        e.printStackTrace();
	    }
	}
	
	//abaEquipamento
	private void salvarTabelaOrcamento(DAO dao, int idEquipamento) {
		for(int i = 0; i < orcamentos.size(); i++) {
			Orcamento orcamento = orcamentos.get(i);
			dao.salvarOrcamento(orcamento, idEquipamento);
		}
	}

	//abaEmpresa
	private int resgatarId(Endereco endereco) {
		int id = endereco.getIdEndereco();
		return id;
	}
	
	//abaEquipamento
	private int resgatarId(Equipamento equipamento) {
		int id = equipamento.getIdEquipamento();
		return id;
	}
	
	//abaEmpresa
	private static void limitarEntrada(JTextField textField, int tipo) {
        AbstractDocument doc = (AbstractDocument) textField.getDocument();
        doc.setDocumentFilter(new InputFilter(tipo));
    }
	
	//pras duas
	public void trocarIcones(TelaFoto telaFoto, JButton botao) {
		if (telaFoto.getFoto() != null) {
			botao.setIcon(new ImageIcon(redmensionarImagem(telaFoto.getFoto())));
		}
	}
	
	//nenhuma
	public void trocarIcones() {
		if (telaFoto1.getFoto() != null) {
			imagem1.setIcon(new ImageIcon(redmensionarImagem(telaFoto1.getFoto())));
		}
		if (telaFoto2.getFoto() != null) {
			imagem2.setIcon(new ImageIcon(redmensionarImagem(telaFoto2.getFoto())));
		}
		if (telaFoto3.getFoto() != null) {
			imagem3.setIcon(new ImageIcon(redmensionarImagem(telaFoto3.getFoto())));
		}
		if (telaFoto4.getFoto() != null) {
			imagem4.setIcon(new ImageIcon(redmensionarImagem(telaFoto4.getFoto())));
		}
		if (telaFoto5.getFoto() != null) {
			imagem5.setIcon(new ImageIcon(redmensionarImagem(telaFoto5.getFoto())));
			
		}
	}
	
	//pras duas
	private Image redmensionarImagem(Image image) {
		Image imagemRedimensionada = image.getScaledInstance(
			    imagem1.getWidth(), 
			    imagem1.getHeight(), 
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
	
	//abaEmpresa
	private void apagarCampos() {
		txtCnpj.setText("");
		txtNome.setText("");
		txtTelefone.setText("");
		txtRua.setText("");
		txtBairro.setText("");
		txtNumero.setText("");
		txtCidade.setText("");
		txtEstado.setText("");
		txtCep.setText("");
		txtTecnico.setText("");
		txtSeguradoCep.setText("");
		txtSeguradoRua.setText("");
		txtSeguradoBairro.setText("");
		txtSeguradoNumero.setText("");
		txtSeguradoCidade.setText("");
		txtSeguradoEstado.setText("");
		txtSeguradoNome.setText("");
	}
}
