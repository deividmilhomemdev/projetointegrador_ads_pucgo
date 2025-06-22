package main.projeto_integrador_1B;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.projeto_integrador_1B.ConexaoDataBase2;
import entidade.projeto_integrador_1B.TbGafanhotos;

public class TbGafanhotosDAOTeste {
	
	public void carregarGafanhoto(TbGafanhotos gafanhoto) {
		
		String sql = "SELECT prof FROM gafanhotos WHERE nome = (?)";
		PreparedStatement ps = null;
		
		try {
			
			ps = ConexaoDataBase2.getConexao().prepareStatement(sql);
			ps.setString(1, gafanhoto.getNome());
			ps.execute();			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
