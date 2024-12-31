package controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexao {
 
	private static final String URL = "jdbc:mysql://localhost:3306/db_seguro" ;
	private static final String USER = "root";
	private static final String PASSWORD = "Edsons6774@!";


	public static Connection getConnection() {
		
		try {
			
			return DriverManager.getConnection(URL, USER, PASSWORD);
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao conectar com o banco de dados", e);
		}
	}
	
	 public static void closeConnection(Connection conn) {
	        if (conn != null) {
	            try {
	                conn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	  }
	 
	 public static void closeStatement(PreparedStatement stmt) {
	        if (stmt != null) {
	            try {
	                stmt.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	 
	 public static void closeResultSet(ResultSet rs) {
	        if (rs != null) {
	            try {
	                rs.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	
	
}
