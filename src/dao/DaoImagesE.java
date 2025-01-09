package dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

import controle.Conexao;

public class DaoImagesE {
	
	private int idEquipamento;
	private int geradorIdEquipamento = 0;
	
	private static PreparedStatement stmt = null;
	private static Connection conn = null;
	
	public DaoImagesE() {
		geradorIdEquipamento++;
		this.idEquipamento = geradorIdEquipamento;
	}
	
	private static final String CRIAR_EQUIPAMENTO = "INSERT INTO imagens_equipamento (id_equipamento, frente, etiqueta, verso, "
			+ "evidencia_danos, local_instalacao) VALUES (?, null, null, null, null, null)";

	public void criarEquipamento() {
		String query = CRIAR_EQUIPAMENTO;
		
		try {
			conn = Conexao.getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, this.idEquipamento);
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	
    // Método para salvar uma imagem em uma coluna específica do banco
    public void salvarImagem(String coluna, FileInputStream fis, int tamanho) {
        String query = "UPDATE imagens_equipamento SET " + coluna + " = ? WHERE id_equipamento = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setBlob(1, fis, tamanho);
           
            stmt.setInt(2, this.idEquipamento);

            stmt.executeUpdate();
            System.out.println("Imagem salva com sucesso na coluna: " + coluna);

        } catch (Exception e) {
            System.out.println("Erro ao salvar imagem na coluna " + coluna + ": " + e.getMessage());
        }
    }


	public int getIdEquipamento() {
		return idEquipamento;
	}


	public void setIdEquipamento(int idEquipamento) {
		this.idEquipamento = idEquipamento;
	}

    
    
    
}
