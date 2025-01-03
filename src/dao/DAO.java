package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controle.Conexao;
import modelo.Assistencia;
import modelo.Endereco;
import modelo.Equipamento;
import modelo.Orcamento;
import modelo.Segurado;
import modelo.composto.AssistenciaCompleta;
import modelo.composto.EquipamentoCompleto;
import modelo.composto.SeguradoCompleto;

public class DAO {
	
	private static PreparedStatement stmt = null;
	private static ResultSet rs = null;
	List <Orcamento> orcamentos = new ArrayList<>();
	
	/* Para salvar a assistencia ou o segurado é preciso que se salve o endereço de cada um, para que
	 * no banco de dados já exista a chave estrangeira. 
	 * E para a outra aba a ordem seria = Orçamento > Equipamento > Peças danificadas
	 */
	
		
	//Querys para salvar no banco de dados
	private final static String SALVAR_ENDERECO = "INSERT INTO endereco (id_endereco, estado, rua, numero, bairro, cidade, cep)"
			+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
	
	private final static String SALVAR_ASSISTENCIA = "INSERT INTO assistencia_tecnica (id_assistencia, cnpj, telefone, "
			+ "nome_assistencia, nome_tecnico, id_endereco) VALUES (?, ?, ?, ?, ?, ?)";
	
	private final static String SALVAR_SEGURADO = "INSERT INTO segurado (id_segurado, nome_segurado, id_endereco) "
			+ "VALUES (?, ?, ?)";
	
	private final static String SALVAR_ORCAMENTO = "INSERT INTO orcamento (id_orcamento, descricao, valor, id_equipamento) VALUES (?, ?, ?, ?)";
	
	private final static String SALVAR_EQUIPAMENTO = "INSERT INTO equipamento (id_equipamento, nome_equipamento, marca, modelo, numero_serie, "
			+ "pecas_danificadas, motivo_dano, possibilidade_reparo, motivo_pt) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	
	//Querys para buscar no banco de dados
	
	private final static String BUSCAR_ASSISTENCIA = "SELECT e.estado, e.rua. e.numero, e.bairro, e.cidade, e.cep "
			+ "a.nome, a.cnpj, a.telefone, a.nome_tecnico FROM endereco AS e INNER JOIN aissistencia_tecnica AS a"
			+ "ON a.id_endereco = e.id_endereco WHERE cnpj = ?";
	
	private final static String BUSCAR_SEGURADO = "SELECT e.estado, e.rua, e.rua. e.numero, e.bairro, e.rua, e.cidade, s.nome"
			+ " FROM endereco AS e INNER JOIN segurado AS s ON s.id_endereco = e.id_endereco WHERE id_segurado = ?";
	
	private final static String BUSCAR_EQUIPAMENTO = "SELECT eq.nome, eq.marca, eq.modelo, eq.numero_serie, eq.pecas_danificadas, "
			+ "eq.motivo_dano, eq.possibilidade_reparo, eq.motivo_pt, o.descricao, o.valor FROM equpamento AS eq "
			+ "INNER JOIN orcamento AS o ON eq.id_equipamento = o.id_equipamento WHERE id_equipamento = ?";

	//Construtor
	public DAO() {
		super();
	}
	
	//Metodos para salvar
	public void salvarEndereco(Endereco endereco) {
		Connection conn = null;
		String query = SALVAR_ENDERECO;
		int i = 1;
		
		try {
			
			conn = Conexao.getConnection();
			stmt = conn.prepareStatement(query);
			
			//estado, rua, numero, bairro, cidade, cep
			stmt.setInt(i++, endereco.getIdEndereco());
			stmt.setString(i++, endereco.getEstado());
			stmt.setString(i++, endereco.getRua());
			stmt.setInt(i++, endereco.getNumero());
			stmt.setString(i++, endereco.getBairro());
			stmt.setString(i++, endereco.getCidade());;
			stmt.setLong(i++, endereco.getCep());
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexao.closeConnection(conn);
			Conexao.closeStatement(stmt);
		}
		
	}

	public void salvarAssistencia(Assistencia assistencia, int idEndereco) {
		Connection conn = null;
		String query = SALVAR_ASSISTENCIA;
		int i = 1;
		
		try {
			
			conn = Conexao.getConnection();
			stmt = conn.prepareStatement(query);
			
			//cnpj, telefone, nome_assistencia, nome_tecnico
			stmt.setInt(i++, assistencia.getIdAssistencia());
			stmt.setString(i++, assistencia.getCnpj());
			stmt.setLong(i++, assistencia.getTelefone());
			stmt.setString(i++, assistencia.getNomeAssistencia());
			stmt.setString(i++, assistencia.getNomeTecnicoCompleto());
			stmt.setInt(i++, idEndereco);
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexao.closeConnection(conn);
			Conexao.closeStatement(stmt);
		}
		
	}
	
	public void salvarSegurado(Segurado segurado, int idEndereco) {
		Connection conn = null;
		String query = SALVAR_SEGURADO;
		int i = 1;
		
		try {
			
			conn = Conexao.getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setInt(i++, segurado.getIdSegurado());
			stmt.setString(i++, segurado.getNome());
			stmt.setInt(i++, idEndereco);

			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexao.closeConnection(conn);
			Conexao.closeStatement(stmt);
		}
	}

	public void salvarOrcamento(Orcamento orcamento, int idEquipamento) {
		Connection conn = null;
		String query = SALVAR_ORCAMENTO;
		int i = 1;
		
		try {
			
			conn = Conexao.getConnection();
			stmt = conn.prepareStatement(query);
			
			stmt.setInt(i++, orcamento.getIdOrcamento());
			stmt.setString(i++, orcamento.getDescricao());
			stmt.setDouble(i++, orcamento.getValor());
			stmt.setInt(i++, idEquipamento);
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexao.closeConnection(conn);
			Conexao.closeStatement(stmt);
		}
		
	}
	
	public void salvarEquipamento(Equipamento equipamento) {
		Connection conn = null;
		String query = SALVAR_EQUIPAMENTO;
		int i = 1;
		
		try {
			
			conn = Conexao.getConnection();
			stmt = conn.prepareStatement(query);
			
			stmt.setInt(i++, equipamento.getIdEquipamento());
			stmt.setString(i++, equipamento.getNomeEquipamento());
			stmt.setString(i++, equipamento.getMarca());
			stmt.setString(i++, equipamento.getModelo());
			stmt.setString(i++, equipamento.getNumeroSerie());
			stmt.setString(i++, equipamento.getPecasDanificadas());
			stmt.setString(i++, equipamento.getMotivoDano());
			stmt.setString(i++, equipamento.getPossibilidadeReparo());
			stmt.setString(i++, equipamento.getMotivoPt());
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexao.closeConnection(conn);
			Conexao.closeStatement(stmt);
		}
		
	}
	
	//Metodos para buscar
	public AssistenciaCompleta buscarAssistencia(String cnpj) {
		Connection conn = null;
		String query = BUSCAR_ASSISTENCIA;
		ResultSet rs = null;
		
		AssistenciaCompleta assistenciaC = null;

		
		try {
            conn = Conexao.getConnection();
            stmt = conn.prepareStatement(query);
            stmt.setString(1, cnpj);
            rs = stmt.executeQuery();

            while(rs.next()){
            	Assistencia assistencia = new Assistencia(
            			rs.getString("nome_assistencia"),
            			rs.getString("cnpj"),
            			rs.getLong("telefone"),
            			rs.getString("nome_tecnico")
            			);
            	
            	Endereco endereco = new Endereco(
            			rs.getString("rua"),
            			rs.getInt("numero"),
            			rs.getString("bairro"),
            			rs.getString("cidade"),
            			rs.getString("estado"),
            			rs.getLong("cep")
            			);
            	            	
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.closeResultSet(rs);
            Conexao.closeStatement(stmt);
            Conexao.closeConnection(conn);
        }
        return assistenciaC;
	}
	
	public SeguradoCompleto buscarSegurado(String nomeSegurado) {
		Connection conn = null;
		String query = BUSCAR_SEGURADO;
		ResultSet rs = null;
		
		SeguradoCompleto seguradoC = null;

		
		try {
            conn = Conexao.getConnection();
            stmt = conn.prepareStatement(query);
            stmt.setString(1, nomeSegurado);
            rs = stmt.executeQuery();

            while(rs.next()){
            	Segurado segurado = new Segurado(
            			rs.getString("nome_segurado")
            			);
            	
            	Endereco endereco = new Endereco(
            			rs.getString("rua"),
            			rs.getInt("numero"),
            			rs.getString("bairro"),
            			rs.getString("cidade"),
            			rs.getString("estado"),
            			rs.getLong("cep")
            			);
            	            	
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.closeResultSet(rs);
            Conexao.closeStatement(stmt);
            Conexao.closeConnection(conn);
        }
        return seguradoC;
	}
	
	public EquipamentoCompleto buscarEquipamento(String nomeEquipamento) {
		Connection conn = null;
		String query = BUSCAR_EQUIPAMENTO;
		ResultSet rs = null;
		
		List <Orcamento> orcamentos = null;
		EquipamentoCompleto equiC = null;

		
		try {
            conn = Conexao.getConnection();
            stmt = conn.prepareStatement(query);
            stmt.setString(1, nomeEquipamento);
            rs = stmt.executeQuery();

            while(rs.next()){
            	
            	Orcamento orcamento = new Orcamento(
            			rs.getString("Descricao"),
            			rs.getDouble("valor")
            			);
            	orcamentos.add(orcamento);
            	
            	Equipamento equipamento = new Equipamento (
            			rs.getString("nome_equipamento"),
            			rs.getString("marca"),
            			rs.getString("modelo"),
            			rs.getString("numero_serie"),
            			rs.getString("pecas_danificadas"),
            			rs.getString("motivo_dano"),
            			rs.getString("possibilidade_reparo"),
            			rs.getString("motivo_pt")
            			);   	
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.closeResultSet(rs);
            Conexao.closeStatement(stmt);
            Conexao.closeConnection(conn);
        }
        return equiC;
	}
	
}

	
	
	
	
	
	