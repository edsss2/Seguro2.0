package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;

import Jm.JMascara;
import controle.InputFilter;
import dao.DAO;
import modelo.Assistencia;
import modelo.Endereco;
import modelo.Segurado;
import view.empresa.TelaFoto;
import view.empresa.TelaFoto;
import view.empresa.TelaFoto1;

public class AbaEmpresa extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextField txtCnpj, txtNome, txtTelefone, txtRua, txtBairro, txtNumero, txtCidade, txtEstado, txtCep, txtTecnico,
	txtSeguradoCep, txtSeguradoRua, txtSeguradoBairro, txtSeguradoNumero, txtSeguradoCidade, txtSeguradoEstado, txtSeguradoNome;
	
	private int cep, seguradoCep;
	private long telefone;
	
	Endereco enderecoAssistencia = new Endereco();
	Endereco enderecoSegurado = new Endereco();
	Assistencia assistencia = new Assistencia();
	Segurado segurado = new Segurado();
	
	public JButton imagem1, imagem2, imagem3, imagem4, imagem5, btnSalvar, btnProsseguir;
	
	public TelaFoto1 tf1;
	public TelaFoto1 tf2;
	public TelaFoto1 tf3;
	public TelaFoto1 tf4;
	public TelaFoto1 tf5;
	
	private JLabel lblDadosAssistencia, lblEndereco, lblBairro, lblRua, lblNumero, lblCidade, lblEstado, lblCep, lblCnpj, lblNome, 
	lblTelefone, lblTecnico, lblDadosSegurado, lblSeguradoEndereco, lblSeguradoBairro, lblSeguradoRua, lblSeguradoNumero, lblSeguradoCidade,
	lblSeguradoEstado, lblSeguradoCep, lblSeguradoNome, lblImagens;

	private void mostrarTela(ActionEvent e, TelaFoto tf) {
		tf.setVisible(true);
	}
	
	//metodo usado no botao salvar
	public void salvarDados() {
		
		try {
			DAO dao = new DAO();
			criarInstancias();
			
			dao.salvarEndereco(enderecoAssistencia); //salva o endereço da assistencia
			int idEnderecoAssistencia = resgatarId(enderecoAssistencia); //armazena o id do endereco em uma variavel
			//repete oque foi feito so que agora com o segurado
			dao.salvarEndereco(enderecoSegurado); 
			int idEnderecoSegurado = resgatarId(enderecoSegurado);
			//assistencia e segurado podem ser salvos agora que eles possuem a chave estrangeira
			dao.salvarAssistencia(assistencia, idEnderecoAssistencia);
			dao.salvarSegurado(segurado, idEnderecoSegurado);
		
			JOptionPane.showMessageDialog(AbaEmpresa.this, "Salvo com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
			//Apaga os textos dos campos
			apagarCampos();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(AbaEmpresa.this, "Erro ao salvar!", "Erro", JOptionPane.ERROR_MESSAGE);
			ex.printStackTrace();
		}
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
	
	private static void limitarEntrada(JTextField textField, int tipo) {
        AbstractDocument doc = (AbstractDocument) textField.getDocument();
        doc.setDocumentFilter(new InputFilter(tipo));
    }
	
	private int resgatarId(Endereco endereco) {
		int id = endereco.getIdEndereco();
		return id;
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
	
	//Método construtor da classe
	public AbaEmpresa(TelaPrincipal telaPrincipal, JTabbedPane tabbedPane) {
		
		setLayout(null);
		
		lblDadosAssistencia = new JLabel("DADOS DA ASSISTÊNCA");
		lblDadosAssistencia.setFont(new Font("Arial Black", Font.PLAIN, 17));
		lblDadosAssistencia.setBounds(22, 10, 350, 55);
		add(lblDadosAssistencia);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNome.setBounds(77, 60, 225, 26); 
		limitarEntrada(txtNome, InputFilter.SOMENTE_LETRAS);
		add(txtNome);
		txtNome.setColumns(10);
		
		lblEndereco = new JLabel("Endereço da Assistência");
		lblEndereco.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblEndereco.setBounds(22, 240, 280, 55);
		add(lblEndereco);
		
		lblRua = new JLabel("Rua:");
		lblRua.setFont(new Font("Arial", Font.PLAIN, 14));
		lblRua.setBounds(22, 290, 35, 30);
		add(lblRua);
		
		lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Arial", Font.PLAIN, 14));
		lblBairro.setBounds(22, 330, 42, 30);
		add(lblBairro);
		
		txtRua = new JTextField();
		txtRua.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtRua.setBounds(77, 290, 345, 26);
		add(txtRua);
		txtRua.setColumns(10);
		
		txtBairro = new JTextField();
		txtBairro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtBairro.setBounds(77, 330, 228, 26);
		add(txtBairro);
		txtBairro.setColumns(10);
		
		lblNumero = new JLabel("N° :");
		lblNumero.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNumero.setBounds(315, 330, 23, 30);
		add(lblNumero);
		
		txtNumero = new JTextField();
		txtNumero.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNumero.setBounds(348, 330, 74, 30);
		limitarEntrada(txtNumero, InputFilter.SOMENTE_NUMEROS);
		add(txtNumero);
		txtNumero.setColumns(10);
		
		lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCidade.setBounds(22, 370, 49, 30);
		add(lblCidade);
		
		txtCidade = new JTextField();
		txtCidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCidade.setBounds(77, 370, 228, 26);
		limitarEntrada(txtCidade, InputFilter.SOMENTE_LETRAS);
		add(txtCidade);
		txtCidade.setColumns(10);
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Arial", Font.PLAIN, 14));
		lblEstado.setBounds(22, 410, 50, 30);
		add(lblEstado);
		
		txtEstado = new JTextField();
		txtEstado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEstado.setBounds(77, 410, 228, 26);
		limitarEntrada(txtEstado, InputFilter.SOMENTE_LETRAS);
		add(txtEstado);
		txtEstado.setColumns(10);
		
		lblCep = new JLabel("Cep:");
		lblCep.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCep.setBounds(22, 450, 45, 30);
		add(lblCep);
		
		lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNome.setBounds(22, 60, 46, 30);
		add(lblNome);
		
		lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCnpj.setBounds(22, 100, 46, 30);
		add(lblCnpj);
		
		
		txtCnpj = new JTextField();
		txtCnpj.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				txtCnpj.setText(JMascara.GetJmascaraCpfCnpj(txtCnpj.getText()));
			}
		});
		txtCnpj.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCnpj.setBounds(77, 100, 225, 26);
		add(txtCnpj);
		txtCnpj.setColumns(10);
		
		lblTelefone = new JLabel("Telefone de Contato:");
		lblTelefone.setFont(new Font("Arial", Font.PLAIN, 14));
		lblTelefone.setBounds(22, 140, 154, 30);
		add(lblTelefone);
		
		lblTecnico = new JLabel("Técnico Responsável:");
		lblTecnico.setFont(new Font("Arial", Font.PLAIN, 14));
		lblTecnico.setBounds(22, 180, 154, 30);
		add(lblTecnico);
		
		txtTecnico = new JTextField();
		txtTecnico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTecnico.setBounds(170, 180, 252, 26);
		limitarEntrada(txtTecnico, InputFilter.SOMENTE_LETRAS);
		add(txtTecnico);
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
		add(txtTelefone);
		txtTelefone.setColumns(10);
		
		
		
		//Segurado
		
		lblDadosSegurado = new JLabel("DADOS DO SEGURADO");
		lblDadosSegurado.setFont(new Font("Arial Black", Font.PLAIN, 17));
		lblDadosSegurado.setBounds(622, 10, 225, 55);
		add(lblDadosSegurado);
		
		lblSeguradoEndereco = new JLabel("Endereço do Segurado");
		lblSeguradoEndereco.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblSeguradoEndereco.setBounds(622, 160, 280, 55);
		add(lblSeguradoEndereco);
		
		lblSeguradoRua = new JLabel("Rua:");
		lblSeguradoRua.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSeguradoRua.setBounds(622, 210, 35, 30);
		add(lblSeguradoRua);
		
		lblSeguradoBairro = new JLabel("Bairro:");
		lblSeguradoBairro.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSeguradoBairro.setBounds(622, 250, 42, 30);
		add(lblSeguradoBairro);
		
		txtSeguradoRua = new JTextField();
		txtSeguradoRua.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtSeguradoRua.setBounds(677, 210, 345, 26);
		add(txtSeguradoRua);
		txtSeguradoRua.setColumns(10);
		
		txtSeguradoBairro = new JTextField();
		txtSeguradoBairro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtSeguradoBairro.setBounds(677, 250, 228, 26);
		add(txtSeguradoBairro);
		txtSeguradoBairro.setColumns(10);
		
		lblSeguradoNumero = new JLabel("N° :");
		lblSeguradoNumero.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSeguradoNumero.setBounds(915, 250, 23, 30);
		add(lblSeguradoNumero);
		
		txtSeguradoNumero = new JTextField();
		txtSeguradoNumero.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtSeguradoNumero.setBounds(948, 250, 74, 30);
		limitarEntrada(txtSeguradoNumero, InputFilter.SOMENTE_NUMEROS);
		add(txtSeguradoNumero);
		txtSeguradoNumero.setColumns(10);
		
		lblSeguradoCidade = new JLabel("Cidade:");
		lblSeguradoCidade.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSeguradoCidade.setBounds(622, 290, 49, 30);
		add(lblSeguradoCidade);
		
		txtSeguradoCidade = new JTextField();
		txtSeguradoCidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtSeguradoCidade.setBounds(677, 290, 228, 26);
		limitarEntrada(txtSeguradoCidade, InputFilter.SOMENTE_LETRAS);
		add(txtSeguradoCidade);
		txtSeguradoCidade.setColumns(10);
		
		lblSeguradoEstado = new JLabel("Estado:");
		lblSeguradoEstado.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSeguradoEstado.setBounds(622, 330, 50, 30);
		add(lblSeguradoEstado);
		
		txtSeguradoEstado = new JTextField();
		txtSeguradoEstado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtSeguradoEstado.setBounds(677, 330, 228, 26);
		limitarEntrada(txtSeguradoEstado, InputFilter.SOMENTE_LETRAS);
		add(txtSeguradoEstado);
		txtSeguradoEstado.setColumns(10);
		
		lblSeguradoCep = new JLabel("Cep:");
		lblSeguradoCep.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSeguradoCep.setBounds(622, 370, 45, 30);
		add(lblSeguradoCep);
		

		
		txtCep = new JTextField();
		txtCep.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				txtCep.setText(JMascara.GetJmascaraCep(txtCep.getText()));
			}
		});
		txtCep.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCep.setBounds(77, 450, 228, 26);
		add(txtCep);
		txtCep.setColumns(10);
		
		txtSeguradoCep = new JTextField();
		txtSeguradoCep.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				txtSeguradoCep.setText(JMascara.GetJmascaraCep(txtSeguradoCep.getText()));
			}
		});
		txtSeguradoCep.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtSeguradoCep.setBounds(677, 370, 228, 26);
		add(txtSeguradoCep);
		txtSeguradoCep.setColumns(10);
		
		
		lblSeguradoNome = new JLabel("Nome do Segurado");
		lblSeguradoNome.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblSeguradoNome.setBounds(622, 80, 225, 30);
		add(lblSeguradoNome);
		
		txtSeguradoNome = new JTextField();
		txtSeguradoNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtSeguradoNome.setBounds(622, 130, 400, 26);
		limitarEntrada(txtSeguradoNome, InputFilter.SOMENTE_LETRAS);
		add(txtSeguradoNome);
		txtSeguradoNome.setColumns(10);
		
		lblImagens = new JLabel("Imagens:");
		lblImagens.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblImagens.setBounds(622, 415, 100, 35);
		add(lblImagens);
		
		PainelImagens painelImagens = new PainelImagens(tf1, tf2, tf3, tf4, tf5);
		painelImagens.setBounds(622, 450, 420, 90);
		add(painelImagens);

		
		JButton btnAdicionarFotos = new JButton("Adicionar fotos");
		btnAdicionarFotos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf1 = new TelaFoto1(telaPrincipal);
				tf1.setVisible(true);
				
			}
		});
		btnAdicionarFotos.setBackground(Color.LIGHT_GRAY);
		btnAdicionarFotos.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		btnAdicionarFotos.setBounds(22, 530, 130, 35);
		add(btnAdicionarFotos);
		
		/* Para salvar a assistencia ou o segurado é preciso que se salve o endereço de cada um, para que
		 * no banco de dados já exista a chave estrangeira. 
		 */
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvarDados();
			
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
		
		btnSalvar.setBackground(Color.LIGHT_GRAY);
		btnSalvar.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		btnSalvar.setBounds(170, 530, 100, 35);
		
		btnProsseguir = new JButton("Prosseguir");
		btnProsseguir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				tabbedPane.setSelectedIndex(1);
			}
		});
		btnProsseguir.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		btnProsseguir.setBackground(Color.LIGHT_GRAY);
		btnProsseguir.setBounds(290, 530, 100, 35);
	}
	

}
