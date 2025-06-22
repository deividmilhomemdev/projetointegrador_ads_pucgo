package conexao.projeto_integrador_1B;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class LendoTabelas {

    public static void main(String[] args) {
    	
        try (Connection conexao = ConexaoDataBase.conectar()) {
            System.out.println("Conexão obtida com sucesso na classe LendoTabelas!");
            
         // 1. Criar a instrução SQL
            String sql = "SELECT * FROM cursos";

            // 2. Criar o objeto Statement para enviar o SQL
            Statement stmt = conexao.createStatement();

            // 3. Executar a consulta e armazenar o resultado no ResultSet
            ResultSet resultado = stmt.executeQuery(sql);

            System.out.println("\n--- RESULTADOS DA CONSULTA ---");

            // 4. Processar os resultados linha por linha
            while (resultado.next()) {
                // Use os nomes exatos das suas colunas aqui
                int id = resultado.getInt("idcurso");
                String nome = resultado.getString("nome");
                String cargaHoraria = resultado.getString("descrição");

                // Imprime os dados no console
                System.out.println("ID: " + id + " | Curso: " + nome + " | Carga Horária: " + cargaHoraria + "h");
            }
            
            System.out.println("--- FIM DOS RESULTADOS ---\n");
            
            // Não é necessário fechar stmt e resultado manualmente por causa do try-with-resources
            // se eles fossem declarados nos parênteses, mas por clareza aqui,
            // o fechamento da 'conexao' já libera os recursos no servidor.
            
            
        } catch (SQLException e) {
            System.err.println("Erro ao obter a conexão ou ao trabalhar com o banco.");
            e.printStackTrace();
        } 
    
        
        System.out.println("Programa finalizado.");
    }
}
