package dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import controle.Conexao;

public class DaoImages {
	private static PreparedStatement stmt = null;
	private static ResultSet rs = null;
	private static Connection conn = null;
	
	private final static String SALVAR_IMAGENS_EMPRESA = "INSERT INTO imagens_empresa (fachada, numero, medidor, quadro_dijuntores, localizacao)"
			+ "(?, ?, ?, ?, ?)";
	
	public void preparaConexao() {
		String query = SALVAR_IMAGENS_EMPRESA;
		
		try {
			
			conn = Conexao.getConnection();
			stmt = conn.prepareStatement(query);
			
		} catch (Exception e) {
			System.out.println(e);
		}
			
	}
	
	public static void setParameters(PreparedStatement stmt, int i, FileInputStream fis, int tamanho) {
		try {
		stmt.setBlob(i, fis, tamanho);
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void fecharConexao() {
		Conexao.closeConnection(conn);
		Conexao.closeStatement(stmt);
	}
	
	public void salvarImagensEmpresa() {
		
		try {
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
