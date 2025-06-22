package conexao.projeto_integrador_1B;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDataBase2 {
	
	private static String NOMEBANCO = "jdbc:mysql://localhost:3306/cadastro";
    private static String USUARIO = "root";
    private static String SENHA = "123456";
    
    private static Connection conn;
      
    public static Connection getConexao() {
    	
    	try {
    		if (conn == null) {
    	 		conn = DriverManager.getConnection(NOMEBANCO,USUARIO,SENHA);
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
