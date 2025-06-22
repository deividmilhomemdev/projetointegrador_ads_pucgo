package main.projeto_integrador_1B;

import java.sql.ResultSet;
import java.sql.Statement;

import entidade.projeto_integrador_1B.TbGafanhotos;

public class Aplicacao {
	
	public static void main(String[]args) throws Exception {
		
		System.out.println("Carregando SQL...");
		
		TbGafanhotos user = new TbGafanhotos();
		user.setNome("Deivid");
		
		new TbGafanhotosDAOTeste().carregarGafanhoto(user);
		
		
		
	}

}
