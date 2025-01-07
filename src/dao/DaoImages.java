package dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

import controle.Conexao;

public class DaoImages {
	
	private int idEmpresa;
	private int geradorId = 0;
	
	private static PreparedStatement stmt = null;
	private static Connection conn = null;
	
	public DaoImages() {
		geradorId++;
		this.idEmpresa = geradorId;
	}
	

	private static final String CRIAR_EMPRESA = "INSERT INTO imagens_empresa (id_empresa, fachada, numero, medidor, "
			+ "quadro_dijuntores, localizacao) VALUES (?, null, null, null, null, null)";
	
	public void criarEmpresa() {
		String query = CRIAR_EMPRESA;
		
		try {
			conn = Conexao.getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, this.idEmpresa);
			
			stmt.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
    // Método para salvar uma imagem em uma coluna específica do banco
    public void salvarImagem(String coluna, FileInputStream fis, int tamanho) {
        String query = "UPDATE imagens_empresa SET " + coluna + " = ? WHERE id_empresa = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setBlob(1, fis, tamanho);
           
            stmt.setInt(2, this.idEmpresa);

            stmt.executeUpdate();
            System.out.println("Imagem salva com sucesso na coluna: " + coluna);

        } catch (Exception e) {
            System.out.println("Erro ao salvar imagem na coluna " + coluna + ": " + e.getMessage());
        }
    }

	public int getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
    
    
    
}
