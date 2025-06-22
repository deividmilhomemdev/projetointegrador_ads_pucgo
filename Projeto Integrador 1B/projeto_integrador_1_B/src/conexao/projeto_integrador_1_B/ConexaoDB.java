package conexao.projeto_integrador_1_B;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {
	
	private static String IDBANCO = "jdbc:mysql://localhost:3306/vacinacao_db";
	private static String USUARIO = "root";
	private static String SENHA = "123456";
	
	private static Connection conn;
	
	public static Connection getConexao() {
		
		try {
			if (conn == null) {
		 		conn = DriverManager.getConnection(IDBANCO,USUARIO,SENHA);
		 		return conn;
			} else {
				return conn;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	

}
