package conexao.projeto_integrador_1B;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDataBase {

    private static String NOMEBANCO = "jdbc:mysql://localhost/cadastro";
    private static String USUARIO = "root";
    private static String SENHA = "123456";


    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(NOMEBANCO, USUARIO, SENHA);
    }
}