package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.util.ArrayList;

import javax.swing.BorderFactory;
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
	
	//Foto
	private FileInputStream fis;
	private int tamanho;
	
	
	

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
		
		JPanel abaEmpresa = new JPanel();
		tabbedPane.addTab("Empresa", null, abaEmpresa, null);
		abaEmpresa.setLayout(null);
		
		JLabel lblDadosAssistencia = new JLabel("DADOS DA ASSISTÊNCA");
		lblDadosAssistencia.setFont(new Font("Arial Black", Font.PLAIN, 17));
		lblDadosAssistencia.setBounds(22, 10, 350, 55);
		abaEmpresa.add(lblDadosAssistencia);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNome.setBounds(77, 60, 225, 26);
		limitarEntrada(txtNome, InputFilter.SOMENTE_LETRAS);
		abaEmpresa.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblEndereco = new JLabel("Endereço da Assistência");
		lblEndereco.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblEndereco.setBounds(22, 240, 280, 55);
		abaEmpresa.add(lblEndereco);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setFont(new Font("Arial", Font.PLAIN, 14));
		lblRua.setBounds(22, 290, 35, 30);
		abaEmpresa.add(lblRua);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Arial", Font.PLAIN, 14));
		lblBairro.setBounds(22, 330, 42, 30);
		abaEmpresa.add(lblBairro);
		
		txtRua = new JTextField();
		txtRua.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtRua.setBounds(77, 290, 345, 26);
		abaEmpresa.add(txtRua);
		txtRua.setColumns(10);
		
		txtBairro = new JTextField();
		txtBairro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtBairro.setBounds(77, 330, 228, 26);
		abaEmpresa.add(txtBairro);
		txtBairro.setColumns(10);
		
		JLabel lblNumero = new JLabel("N° :");
		lblNumero.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNumero.setBounds(315, 330, 23, 30);
		abaEmpresa.add(lblNumero);
		
		txtNumero = new JTextField();
		txtNumero.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNumero.setBounds(348, 330, 74, 30);
		limitarEntrada(txtNumero, InputFilter.SOMENTE_NUMEROS);
		abaEmpresa.add(txtNumero);
		txtNumero.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCidade.setBounds(22, 370, 49, 30);
		abaEmpresa.add(lblCidade);
		
		txtCidade = new JTextField();
		txtCidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCidade.setBounds(77, 370, 228, 26);
		limitarEntrada(txtCidade, InputFilter.SOMENTE_LETRAS);
		abaEmpresa.add(txtCidade);
		txtCidade.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Arial", Font.PLAIN, 14));
		lblEstado.setBounds(22, 410, 50, 30);
		abaEmpresa.add(lblEstado);
		
		txtEstado = new JTextField();
		txtEstado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEstado.setBounds(77, 410, 228, 26);
		limitarEntrada(txtEstado, InputFilter.SOMENTE_LETRAS);
		abaEmpresa.add(txtEstado);
		txtEstado.setColumns(10);
		
		JLabel lblCep = new JLabel("Cep:");
		lblCep.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCep.setBounds(22, 450, 45, 30);
		abaEmpresa.add(lblCep);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNome.setBounds(22, 60, 46, 30);
		abaEmpresa.add(lblNome);
		
		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCnpj.setBounds(22, 100, 46, 30);
		abaEmpresa.add(lblCnpj);
		
		
		txtCnpj = new JTextField();
		txtCnpj.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				txtCnpj.setText(JMascara.GetJmascaraCpfCnpj(txtCnpj.getText()));
			}
		});
		txtCnpj.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCnpj.setBounds(77, 100, 225, 26);
		abaEmpresa.add(txtCnpj);
		txtCnpj.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone de Contato:");
		lblTelefone.setFont(new Font("Arial", Font.PLAIN, 14));
		lblTelefone.setBounds(22, 140, 154, 30);
		abaEmpresa.add(lblTelefone);
		
		JLabel lblTecnico = new JLabel("Técnico Responsável:");
		lblTecnico.setFont(new Font("Arial", Font.PLAIN, 14));
		lblTecnico.setBounds(22, 180, 154, 30);
		abaEmpresa.add(lblTecnico);
		
		txtTecnico = new JTextField();
		txtTecnico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTecnico.setBounds(170, 180, 252, 26);
		limitarEntrada(txtTecnico, InputFilter.SOMENTE_LETRAS);
		abaEmpresa.add(txtTecnico);
		txtTecnico.setColumns(10);
		

		txtTelefone = new JTextField();
		txtTelefone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				txtTelefone.setText(JMascara.GetJmascaraFone(txtTelefone.getText()));
			}
		});
		txtTelefone.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTelefone.setBounds(170, 140, 252, 26);
		abaEmpresa.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		
		
		//Segurado
		
		JLabel lblDadosSegurado = new JLabel("DADOS DO SEGURADO");
		lblDadosSegurado.setFont(new Font("Arial Black", Font.PLAIN, 17));
		lblDadosSegurado.setBounds(622, 10, 225, 55);
		abaEmpresa.add(lblDadosSegurado);
		
		JLabel lblSeguradoEndereco = new JLabel("Endereço do Segurado");
		lblSeguradoEndereco.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblSeguradoEndereco.setBounds(622, 240, 280, 55);
		abaEmpresa.add(lblSeguradoEndereco);
		
		JLabel lblSeguradoRua = new JLabel("Rua:");
		lblSeguradoRua.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSeguradoRua.setBounds(622, 290, 35, 30);
		abaEmpresa.add(lblSeguradoRua);
		
		JLabel lblSeguradoBairro = new JLabel("Bairro:");
		lblSeguradoBairro.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSeguradoBairro.setBounds(622, 330, 42, 30);
		abaEmpresa.add(lblSeguradoBairro);
		
		txtSeguradoRua = new JTextField();
		txtSeguradoRua.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtSeguradoRua.setBounds(677, 290, 345, 26);
		abaEmpresa.add(txtSeguradoRua);
		txtSeguradoRua.setColumns(10);
		
		txtSeguradoBairro = new JTextField();
		txtSeguradoBairro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtSeguradoBairro.setBounds(677, 330, 228, 26);
		abaEmpresa.add(txtSeguradoBairro);
		txtSeguradoBairro.setColumns(10);
		
		JLabel lblSeguradoNumero = new JLabel("N° :");
		lblSeguradoNumero.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSeguradoNumero.setBounds(915, 330, 23, 30);
		abaEmpresa.add(lblSeguradoNumero);
		
		txtSeguradoNumero = new JTextField();
		txtSeguradoNumero.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtSeguradoNumero.setBounds(948, 330, 74, 30);
		limitarEntrada(txtSeguradoNumero, InputFilter.SOMENTE_NUMEROS);
		abaEmpresa.add(txtSeguradoNumero);
		txtSeguradoNumero.setColumns(10);
		
		JLabel lblSeguradoCidade = new JLabel("Cidade:");
		lblSeguradoCidade.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSeguradoCidade.setBounds(622, 370, 49, 30);
		abaEmpresa.add(lblSeguradoCidade);
		
		txtSeguradoCidade = new JTextField();
		txtSeguradoCidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtSeguradoCidade.setBounds(677, 370, 228, 26);
		limitarEntrada(txtSeguradoCidade, InputFilter.SOMENTE_LETRAS);
		abaEmpresa.add(txtSeguradoCidade);
		txtSeguradoCidade.setColumns(10);
		
		JLabel lblSeguradoEstado = new JLabel("Estado:");
		lblSeguradoEstado.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSeguradoEstado.setBounds(622, 410, 50, 30);
		abaEmpresa.add(lblSeguradoEstado);
		
		txtSeguradoEstado = new JTextField();
		txtSeguradoEstado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtSeguradoEstado.setBounds(677, 410, 228, 26);
		limitarEntrada(txtSeguradoEstado, InputFilter.SOMENTE_LETRAS);
		abaEmpresa.add(txtSeguradoEstado);
		txtSeguradoEstado.setColumns(10);
		
		JLabel lblSeguradoCep = new JLabel("Cep:");
		lblSeguradoCep.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSeguradoCep.setBounds(622, 450, 45, 30);
		abaEmpresa.add(lblSeguradoCep);
		

		
		txtCep = new JTextField();
		txtCep.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				txtCep.setText(JMascara.GetJmascaraCep(txtCep.getText()));
			}
		});
		txtCep.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCep.setBounds(77, 453, 228, 26);
		abaEmpresa.add(txtCep);
		txtCep.setColumns(10);
		
		txtSeguradoCep = new JTextField();
		txtSeguradoCep.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				txtSeguradoCep.setText(JMascara.GetJmascaraCep(txtSeguradoCep.getText()));
			}
		});
		txtSeguradoCep.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtSeguradoCep.setBounds(677, 453, 228, 26);
		abaEmpresa.add(txtSeguradoCep);
		txtSeguradoCep.setColumns(10);
		
		
		JLabel lblSeguradoNome = new JLabel("Nome do Segurado");
		lblSeguradoNome.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblSeguradoNome.setBounds(622, 80, 225, 30);
		abaEmpresa.add(lblSeguradoNome);
		
		txtSeguradoNome = new JTextField();
		txtSeguradoNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtSeguradoNome.setBounds(622, 130, 400, 26);
		limitarEntrada(txtSeguradoNome, InputFilter.SOMENTE_LETRAS);
		abaEmpresa.add(txtSeguradoNome);
		txtSeguradoNome.setColumns(10);
		
		
		/* Para salvar a assistencia ou o segurado é preciso que se salve o endereço de cada um, para que
		 * no banco de dados já exista a chave estrangeira. 
		 */
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				//Cria a instancia do DAO para salvar no banco de dados
				DAO dao = new DAO();
					
					//Cria instancias das classes modelos a serem salvas
				criarInstancias();
					
				dao.salvarEndereco(enderecoAssistencia);
				/*Após salvar o endereco é gerado o id daquele endreço que vai para o banco de dados,
				* uso o metodo "resgatarId" para armazenar esse id em uma variavel, para passar essa variavel
				* para o metodo de salvar assistencia.
				*/
				int idEnderecoAssistencia = resgatarId(enderecoAssistencia);
				dao.salvarEndereco(enderecoSegurado);
				int idEnderecoSegurado = resgatarId(enderecoSegurado);
				dao.salvarAssistencia(assistencia, idEnderecoAssistencia);
				dao.salvarSegurado(segurado, idEnderecoSegurado);
				
				//Apaga os textos dos campos
				apagarCampos();
				
				JOptionPane.showMessageDialog(null, "Salvo com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		
		btnSalvar.setBorder(BorderFactory.createEtchedBorder());
		btnSalvar.setBackground(Color.LIGHT_GRAY);
		btnSalvar.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		btnSalvar.setBounds(140, 530, 100, 35);
		abaEmpresa.add(btnSalvar);
		
		JButton btnProsseguir = new JButton("Prosseguir");
		btnProsseguir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		btnProsseguir.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		btnProsseguir.setBorder(UIManager.getBorder("DesktopIcon.border"));
		btnProsseguir.setBackground(Color.LIGHT_GRAY);
		btnProsseguir.setBounds(260, 530, 100, 35);
		abaEmpresa.add(btnProsseguir);
		
		
		JPanel abaEquipamento = new JPanel();
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
		
		
		JButton btnSalvarEquipamento = new JButton("Salvar");
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
		
		btnSalvarEquipamento.setBorder(BorderFactory.createEtchedBorder());
		btnSalvarEquipamento.setBackground(Color.LIGHT_GRAY);
		btnSalvarEquipamento.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		btnSalvarEquipamento.setBounds(870, 500, 100, 35);
		abaEquipamento.add(btnSalvarEquipamento);
		
		JButton btnProsseguirEquipamento = new JButton("Prosseguir");
		btnProsseguirEquipamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnProsseguirEquipamento.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		btnProsseguirEquipamento.setBorder(UIManager.getBorder("DesktopIcon.border"));
		btnProsseguirEquipamento.setBackground(Color.LIGHT_GRAY);
		btnProsseguirEquipamento.setBounds(990, 500, 100, 35);
		abaEquipamento.add(btnProsseguirEquipamento);
		
		
	
		
	}

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
	
	private void salvarTabelaOrcamento(DAO dao, int idEquipamento) {
		for(int i = 0; i < orcamentos.size(); i++) {
			Orcamento orcamento = orcamentos.get(i);
			dao.salvarOrcamento(orcamento, idEquipamento);
		}
	}

	private int resgatarId(Endereco endereco) {
		int id = endereco.getIdEndereco();
		return id;
	}
	
	
	private int resgatarId(Equipamento equipamento) {
		int id = equipamento.getIdEquipamento();
		return id;
	}
	
	private static void limitarEntrada(JTextField textField, int tipo) {
        AbstractDocument doc = (AbstractDocument) textField.getDocument();
        doc.setDocumentFilter(new InputFilter(tipo));
    }
	
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
