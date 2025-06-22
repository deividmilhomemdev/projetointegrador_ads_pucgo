package banco.projeto_integrador_1_B;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import conexao.projeto_integrador_1_B.ConexaoDB;
import entidades.projeto_integrador_1_B.EntidadePaciente;

public class ConsultaDB {
	
	public void consultarPaciente(EntidadePaciente paciente) {

        String sql = "SELECT p.nome, v.nome_da_vacina, vv.data_vacinacao, vv.numero_dose " +
                     "FROM vacinado_vacinacao AS vv " +
                     "JOIN paciente AS p ON vv.id_paciente = p.id_paciente " +
                     "JOIN vacina AS v ON vv.id_vacina = v.id_vacina " +
                     "WHERE p.nome = ?";
        PreparedStatement ps = null;
        
        try {
        		ps = ConexaoDB.getConexao().prepareStatement(sql);
        		ps.setString(1, paciente.getNome());
        		ResultSet resultado = ps.executeQuery();
                boolean encontrou = false;
                while (resultado.next()) {
                    if(!encontrou) {
                        System.out.println("\n--- Carteira de Vacinação de: " + resultado.getString("nome") + " ---");
                        encontrou = true;
                    }
                    System.out.printf("Vacina: %-25s | Data: %s | Dose: %d\n", 
                        resultado.getString("nome_da_vacina"), 
                        resultado.getDate("data_vacinacao"), 
                        resultado.getInt("numero_dose"));
                	}
                	if(!encontrou) {
                    System.out.println("\n**Nenhum registro encontrado ou paciente não vacinado**\n\n");
                	}
                	
                resultado.close();
                ps.close();
            } catch (SQLException e) {
	            System.out.println("Erro ao executar consulta.");
	            e.printStackTrace();
        }
	}
	
	
	public void relatorioVacinacao() {

        String sql = "SELECT p.nome, p.cpf, COUNT(vv.id_vacinacao) AS quantidade_de_vacinas " +
                     "FROM paciente p " +
                     "LEFT JOIN vacinado_vacinacao vv ON p.id_paciente = vv.id_paciente " +
                     "GROUP BY p.id_paciente, p.nome, p.cpf " +
                     "ORDER BY p.nome ASC";
        
        PreparedStatement ps = null;
        
        try {
 
        		ps = ConexaoDB.getConexao().prepareStatement(sql);
        		ResultSet resultado = ps.executeQuery();

                System.out.println("\n--- Relatório de Pacientes versus Quantidade de Vacinas ---");
                System.out.printf("%-40s | %-15s | %s\n", "NOME DO PACIENTE", "CPF", "QTD. VACINAS");
                System.out.println("-------------------------------------------------------------------------");
                
                while (resultado.next()) {
                    String nome = resultado.getString("nome");
                    String cpf = resultado.getString("cpf");
                    int quantidade = resultado.getInt("quantidade_de_vacinas");
                    
                    System.out.printf("%-40s | %-15s | %d\n", nome, cpf, quantidade);
                }
                
                System.out.println("-------------------------------------------------------------------------");
                
                resultado.close();
                ps.close();

            } catch (SQLException e) {
	            System.out.println("Erro ao executar consulta de relatório.");
	            e.printStackTrace();
        }
	}
	
	public void resultadoCampanha() {

        String sqlCampanha = "SELECT p.UF, " +
                "COUNT(DISTINCT p.id_paciente) AS pacientes_vacinados_no_estado, " +
                "COUNT(vv.id_vacinacao) AS total_doses_aplicadas, " +
                "COUNT(DISTINCT p.municipio) AS municipios_com_vacinacao " +
                "FROM paciente p " +
                "INNER JOIN vacinado_vacinacao vv ON p.id_paciente = vv.id_paciente " +
                "GROUP BY p.UF " +
                "ORDER BY pacientes_vacinados_no_estado DESC";
        
        String sqlVacinas = "SELECT v.nome_da_vacina, COUNT(vv.id_vacinacao) AS total_doses_aplicadas " +
                "FROM vacina v " +
                "INNER JOIN vacinado_vacinacao vv ON v.id_vacina = vv.id_vacina " +
                "GROUP BY v.id_vacina, v.nome_da_vacina " +
                "ORDER BY total_doses_aplicadas DESC";
        
        PreparedStatement ps = null;
        
        try {
        		ps = ConexaoDB.getConexao().prepareStatement(sqlCampanha);
        		ResultSet resultadoCampanha = ps.executeQuery();

                System.out.println("\n--- Relatório: Resultado Atual das Campanhas ---");
                System.out.printf("%-10s | %-28s | %-22s | %s\n", "UF", "PACIENTES ÚNICOS VACINADOS", "TOTAL DE DOSES", "MUNICÍPIOS ATINGIDOS");
                System.out.println("----------------------------------------------------------------------------------------------------");
                
                while (resultadoCampanha.next()) {
                    String uf = resultadoCampanha.getString("UF");
                    int pacientesPorEstado = resultadoCampanha.getInt("pacientes_vacinados_no_estado");
                    int totalDoses = resultadoCampanha.getInt("total_doses_aplicadas");
                    int totalMunicipios = resultadoCampanha.getInt("municipios_com_vacinacao");
                    System.out.printf("%-10s | %-28d | %-22d | %d\n", uf, pacientesPorEstado, totalDoses, totalMunicipios);
                }
                resultadoCampanha.close();
                ps.close();
                
                ps = ConexaoDB.getConexao().prepareStatement(sqlVacinas);
        		ResultSet resultadoVacinas = ps.executeQuery();
        		 System.out.println("\n--- Relação de Vacinas Aplicadas ---");
                 System.out.printf("%-25s | %s\n", "TIPO DE VACINA", "TOTAL DE DOSES APLICADAS");
                 System.out.println("---------------------------------------------------------");
                 
                 while (resultadoVacinas.next()) {
                     String nomeVacina = resultadoVacinas.getString("nome_da_vacina");
                     int totalDoses = resultadoVacinas.getInt("total_doses_aplicadas");
                     
                     System.out.printf("%-25s | %d\n", nomeVacina, totalDoses);
                 }
                 resultadoVacinas.close();
                 ps.close();
                 
                System.out.println("-----------------------------------------------------------------");
                
               

            } catch (SQLException e) {
	            System.out.println("Erro ao executar relatório geográfico.");
	            e.printStackTrace();
        }
	}
	
}