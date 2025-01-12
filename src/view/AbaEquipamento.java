package view;

<<<<<<< HEAD
import javax.swing.JPanel;
=======
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;

import dao.DAO;
import modelo.Equipamento;
import modelo.ModeloTabela;
import modelo.Orcamento;
import view.empresa.TelaFotoEquipamento1;
>>>>>>> 12d6876 (Abas separadas)

public class AbaEquipamento extends JPanel {

	private static final long serialVersionUID = 1L;
<<<<<<< HEAD
=======
	
	private JScrollPane scrollPane;
	
	private ArrayList<Orcamento> orcamentos;
	Equipamento equipamento = new Equipamento();
	
	private JTextField txtNomeEquipamento, txtMarca, txtModelo, txtNumeroSerie;
	private String possibilidadeReparo;
	private JTable table;
	
	private JLabel lblDadosEquipamento, lblNomeEquipamento, lblMarca, lblModelo, lblNumeroSerie, lblPossibilidadeReparo,
	lblComponentesDanificados, lblMotivoDano, lblPt, lblOrcamento, lblImagensEquipamento;
	
	private JCheckBox jCheckBoxPossibilidadeReparo;
	
	private JEditorPane jepPecasDanificadas, jepMotivoDano, jepPt;
		
	public JButton btnSalvarEquipamento, btnProsseguirEquipamento;
	private JButton btnAddFotoEquipamento, btnAdicionarLinha, btnRemoverLinha;
	
	private ModeloTabela modeloTabela;
	public PainelImagens painelImagens;
>>>>>>> 12d6876 (Abas separadas)

	/**
	 * Create the panel.
	 */
<<<<<<< HEAD
	public AbaEquipamento() {

	}

=======
	public AbaEquipamento(TelaPrincipal telaPrincipal) {
		//aba Equipamento
		
				//tabbedPane.addTab("Equipamento", null, abaEquipamento, null);
				setLayout(null);
				
				lblDadosEquipamento = new JLabel("DADOS DO EQUIPAMENTO");
				lblDadosEquipamento.setFont(new Font("Arial Black", Font.PLAIN, 17));
				lblDadosEquipamento.setBounds(22, 10, 350, 55);
				add(lblDadosEquipamento);
				
				lblNomeEquipamento = new JLabel("Nome do Equipamento:");
				lblNomeEquipamento.setFont(new Font("Arial", Font.PLAIN, 14));
				lblNomeEquipamento.setBounds(22, 60, 158, 30);
				add(lblNomeEquipamento);
				
				txtNomeEquipamento = new JTextField();
				txtNomeEquipamento.setBounds(175, 60, 255, 26);
				add(txtNomeEquipamento);
				txtNomeEquipamento.setColumns(10);
				
				lblMarca = new JLabel("Marca:");
				lblMarca.setFont(new Font("Arial", Font.PLAIN, 14));
				lblMarca.setBounds(22, 100, 49, 30);
				add(lblMarca);
				
				txtMarca = new JTextField();
				txtMarca.setBounds(81, 100, 180, 26);
				add(txtMarca);
				txtMarca.setColumns(10);
				
				lblModelo = new JLabel("Modelo:");
				lblModelo.setFont(new Font("Arial", Font.PLAIN, 14));
				lblModelo.setBounds(22, 140, 55, 30);
				add(lblModelo);
				
				txtModelo = new JTextField();
				txtModelo.setBounds(81, 140, 180, 26);
				add(txtModelo);
				txtModelo.setColumns(10);
				
				lblNumeroSerie = new JLabel("Número de série:");
				lblNumeroSerie.setFont(new Font("Arial", Font.PLAIN, 14));
				lblNumeroSerie.setBounds(22, 180, 114, 30);
				add(lblNumeroSerie);
				
				txtNumeroSerie = new JTextField();
				txtNumeroSerie.setBounds(136, 180, 180, 26);
				add(txtNumeroSerie);
				txtNumeroSerie.setColumns(10);
				
				lblPossibilidadeReparo = new JLabel("Há possibilidade de reparo do equipamento?");
				lblPossibilidadeReparo.setFont(new Font("Arial Black", Font.PLAIN, 13));
				lblPossibilidadeReparo.setBounds(22, 220, 340, 30);
				add(lblPossibilidadeReparo);
				
				jCheckBoxPossibilidadeReparo = new JCheckBox("Sim");
				jCheckBoxPossibilidadeReparo.setFont(new Font("Arial", Font.PLAIN, 14));
				jCheckBoxPossibilidadeReparo.setBounds(22, 250, 50, 23);
				add(jCheckBoxPossibilidadeReparo);
				
				lblComponentesDanificados = new JLabel("Componentes(peças)  danificados nos equipamentos:");
				lblComponentesDanificados.setFont(new Font("Arial Black", Font.PLAIN, 13));
				lblComponentesDanificados.setBounds(22, 380, 400, 30);
				add(lblComponentesDanificados);
				
				jepPecasDanificadas = new JEditorPane();
				jepPecasDanificadas.setFont(new Font("Tahoma", Font.PLAIN, 12));
				jepPecasDanificadas.setBorder(UIManager.getBorder("DesktopIcon.border"));
				jepPecasDanificadas.setText("Nome dos Componentes/peças danificados");
				jepPecasDanificadas.setBounds(22, 410, 450, 60);
				add(jepPecasDanificadas);
				
				lblMotivoDano = new JLabel("Causa conclusiva do dano na peça/ componentes (motivo do dano):");
				lblMotivoDano.setFont(new Font("Arial Black", Font.PLAIN, 13));
				lblMotivoDano.setBounds(22, 280, 558, 30);
				add(lblMotivoDano);
				
				jepMotivoDano = new JEditorPane();
				jepMotivoDano.setFont(new Font("Tahoma", Font.PLAIN, 12));
				jepMotivoDano.setBorder(UIManager.getBorder("DesktopIcon.border"));
				jepMotivoDano.setText("Causa do dano após avaliação do técnico");
				jepMotivoDano.setBounds(22, 310, 450, 60);
				add(jepMotivoDano);
				
				lblPt = new JLabel("Se for perda total do equipamento, qual o motivo da perda total do equipamento?");
				lblPt.setFont(new Font("Arial Black", Font.PLAIN, 13));
				lblPt.setBounds(22, 480, 600, 30);
				add(lblPt);
				
				jepPt = new JEditorPane();
				jepPt.setFont(new Font("Tahoma", Font.PLAIN, 12));
				jepPt.setBorder(UIManager.getBorder("DesktopIcon.border"));
				jepPt.setText("Causa do dano após avaliação do técnico");
				jepPt.setBounds(22, 510, 450, 60);
				add(jepPt);
				
				
				//Orcamento
				
				lblOrcamento = new JLabel("ORÇAMENTO DE REPARO DO EQUIPAMENTO");
				lblOrcamento.setFont(new Font("Arial Black", Font.PLAIN, 17));
				lblOrcamento.setBounds(622, 10, 427, 55);
				add(lblOrcamento);
				
				scrollPane = new JScrollPane();
				scrollPane.setBounds(622, 60, 480, 200);
				add(scrollPane);
				
				orcamentos = new ArrayList<>();
				modeloTabela = new ModeloTabela(orcamentos);
				table = new JTable();
				
				table.setModel(modeloTabela);
				table.getColumnModel().getColumn(1).setMaxWidth(90);;
		        table.getColumnModel().getColumn(1).setPreferredWidth(80);
		        table.getColumnModel().getColumn(1).setMinWidth(70);       
		        table.setFont(new Font("Tahoma", Font.PLAIN, 12));

		        
		        table.setRowHeight(25); 
		        
				scrollPane.setViewportView(table);
				
				btnAdicionarLinha = new JButton("Adicionar Linha");
				btnAdicionarLinha.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						modeloTabela.addRow(new Orcamento(" ", 0.0)); 
					}
				});
				
				btnAdicionarLinha.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
				btnAdicionarLinha.setBorder(UIManager.getBorder("DesktopIcon.border"));
				btnAdicionarLinha.setBackground(Color.LIGHT_GRAY);
				btnAdicionarLinha.setBounds(622, 270, 120, 35);
				add(btnAdicionarLinha);

				btnRemoverLinha = new JButton("Remover Linha");
				btnRemoverLinha.addActionListener(this :: removerLinha);
				
				btnRemoverLinha.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
				btnRemoverLinha.setBorder(UIManager.getBorder("DesktopIcon.border"));
				btnRemoverLinha.setBackground(Color.LIGHT_GRAY);
				btnRemoverLinha.setBounds(772, 270, 120, 35);
				add(btnRemoverLinha);
				
				
				btnSalvarEquipamento = new JButton("Salvar");
				btnSalvarEquipamento.addActionListener(this :: salvarEquipamento);
				
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
						telaPrincipal.tfe1 = new TelaFotoEquipamento1(telaPrincipal, painelImagens);
						telaPrincipal.tfe1.setVisible(true);
						
					}
				});
				btnAddFotoEquipamento.setBackground(Color.LIGHT_GRAY);
				btnAddFotoEquipamento.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
				btnAddFotoEquipamento.setBounds(720, 500, 130, 35);
				add(btnAddFotoEquipamento);
				
				lblImagensEquipamento = new JLabel("Imagens:");
				lblImagensEquipamento.setFont(new Font("Arial Black", Font.PLAIN, 15));
				lblImagensEquipamento.setBounds(622, 335, 100, 35);
				add(lblImagensEquipamento);
				
				painelImagens = new PainelImagens(telaPrincipal.tfe1, telaPrincipal.tfe2, telaPrincipal.tfe3, 
						telaPrincipal.tfe4, telaPrincipal.tfe5);
				painelImagens.setBounds(622, 420, 420, 90);
				add(painelImagens);
				
			
			}
	
	private void salvarEquipamento(ActionEvent e) {
		try {
			DAO dao = new DAO();
			resgatarCheckBox();
			
			equipamento = new Equipamento(
					txtNomeEquipamento.getText(),
					txtMarca.getText(),
					txtModelo.getText(),
					txtNumeroSerie.getText(),
					jepPecasDanificadas.getText(),
					jepMotivoDano.getText(),
					possibilidadeReparo,
					jepPt.getText()
					);
			
			dao.salvarEquipamento(equipamento);
			int idEquipamento = resgatarId(equipamento);
			salvarTabelaOrcamento(dao, idEquipamento);
			
			JOptionPane.showMessageDialog(null, "Salvo com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(AbaEquipamento.this, "Erro ao salvar!", "Erro", JOptionPane.ERROR_MESSAGE);
			e2.printStackTrace();
		}
	}
	
	
	private void resgatarCheckBox() {
		if (jCheckBoxPossibilidadeReparo.isSelected()) {
			possibilidadeReparo = "Sim";
		} else {
			possibilidadeReparo = "Não";
		}
	}

			private void removerLinha(ActionEvent e) {
				int linhaSelecionada = table.getSelectedRow();
	            if (linhaSelecionada != -1) {
	                modeloTabela.removeRow(linhaSelecionada);
	            } else {
	                JOptionPane.showMessageDialog(this, "Selecione uma linha para remover.");
	            }
			}
			
			//abaEquipamento
			private void salvarTabelaOrcamento(DAO dao, int idEquipamento) {
				for(int i = 0; i < orcamentos.size(); i++) {
					Orcamento orcamento = orcamentos.get(i);
					dao.salvarOrcamento(orcamento, idEquipamento);
				}
			}

			
			//abaEquipamento
			private int resgatarId(Equipamento equipamento) {
				int id = equipamento.getIdEquipamento();
				return id;
			}
	

>>>>>>> 12d6876 (Abas separadas)
}
