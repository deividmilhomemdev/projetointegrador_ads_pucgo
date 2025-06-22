package banco.projeto_integrador_1_B;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import conexao.projeto_integrador_1_B.ConexaoDB;
import entidades.projeto_integrador_1_B.EntidadePaciente;

public class EnvioDB {

	public void cadastroPaciente(EntidadePaciente paciente) {
		
		String sql = "INSERT INTO paciente (cpf,nome,data_nascimento, endereco, municipio, UF, telefone,escolaridade) values (?,?,?,?,?,?,?,?)";
		PreparedStatement ps = null;
		
		try {
			ps = ConexaoDB.getConexao().prepareStatement(sql);
			ps.setString(1, paciente.getCpf());
			ps.setString(2, paciente.getNome());
			ps.setString(3, paciente.getData_nascimento());
			ps.setString(4, paciente.getEndereco());
			ps.setString(5, paciente.getMunicipio());
			ps.setString(6, paciente.getUF());
			ps.setString(7, paciente.getTelefone());
			ps.setString(8, paciente.getEscolaridade());
			
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			System.out.println("Erro ao preparar envio.");
			e.printStackTrace();	
		}
	}

}
