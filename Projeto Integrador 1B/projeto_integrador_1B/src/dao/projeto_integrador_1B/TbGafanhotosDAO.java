package dao.projeto_integrador_1B;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.projeto_integrador_1B.ConexaoDataBase2;
import entidade.projeto_integrador_1B.TbGafanhotos;

public class TbGafanhotosDAO {
	
	public void cadastrarGafanhoto(TbGafanhotos gafanhoto) {
		
		String sql = "INSERT INTO gafanhotos (nome, prof,sexo,peso,altura,nacionalidade) VALUES (?,?,?,?,?,?)";
		PreparedStatement ps = null;
		

		try {
			ps = ConexaoDataBase2.getConexao().prepareStatement(sql);
			ps.setString(1, gafanhoto.getNome());
			ps.setString(2, gafanhoto.getProf());
			ps.setString(3, gafanhoto.getSexo());
			ps.setFloat(4, gafanhoto.getPeso());
			ps.setFloat(5, gafanhoto.getAltura());
			ps.setString(6, gafanhoto.getNacionalidade());
			
			ps.execute();			
			ps.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
