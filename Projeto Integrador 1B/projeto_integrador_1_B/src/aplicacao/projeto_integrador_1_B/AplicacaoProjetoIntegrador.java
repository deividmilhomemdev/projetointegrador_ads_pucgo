package aplicacao.projeto_integrador_1_B;

import entidades.projeto_integrador_1_B.EntidadePaciente;
import java.util.Scanner;
import banco.projeto_integrador_1_B.ConsultaDB;
import banco.projeto_integrador_1_B.EnvioDB;

public class AplicacaoProjetoIntegrador {
	
	public static void main(String[]args) {
		
		int selecao;
		selecao = 0;
		Scanner scan = new Scanner(System.in);
		
				
		do {
			
			System.out.println("SISTEMA DE CONTROLE DE VACINAÇÃO");
			System.out.println(">>>>>>>>>>>  MENU  <<<<<<<<<<<<<\nSelecione uma das opções disponíveis: \n\n");
			System.out.println("1- Cadastrar Paciente\n2- Consultar Cartão de Vacinação \n3- Relatório de Vacinação \n4- Acompanhar Campanha de Vacinação \n9- Sair");
			
			selecao = scan.nextInt();
			
			switch (selecao){
				
			case 1:
				int sair1 = 1;
				do {
				System.out.println("OPÇÃO 1- Cadastrar Paciente.");
				EntidadePaciente cadastrarPaciente = new EntidadePaciente();
				
				scan.nextLine();
				System.out.println("Informe o Nome do Paciente: ");
				String nome = scan.nextLine();
				cadastrarPaciente.setNome(nome);
				
				
				System.out.println("> Informe o CPF (11 dígitos): ");
				String cpf = scan.next();
				cadastrarPaciente.setCpf(cpf);
		
				
				System.out.println("Informe a data de nascimento (aaaa-mm-dd): ");
				String dataNascimento = scan.next();
				cadastrarPaciente.setData_nascimento(dataNascimento);
				
				scan.nextLine(); 
				System.out.println("Informe o endereço: ");
				String endereco = scan.nextLine();
				cadastrarPaciente.setEndereco(endereco);
				
				 
				System.out.println("Informe o municipio: ");
				String municipio = scan.nextLine();
				cadastrarPaciente.setMunicipio(municipio);
				
				System.out.println("Informe a UF: ");
				String uf = scan.next();
				cadastrarPaciente.setUF(uf);
				
				scan.nextLine(); 
				System.out.println("Informe seu telefone: ");
				String telefone = scan.nextLine();
				cadastrarPaciente.setTelefone(telefone);
				
				System.out.println("Informe seu grau de escolaridade: ");
				String escolaridade = scan.next();
				cadastrarPaciente.setEscolaridade(escolaridade);
				
				System.out.println("Dados registrados com sucesso! Tabela 'Paciente'. ");
				new  EnvioDB().cadastroPaciente(cadastrarPaciente);
				
				System.out.println("Retornar ao menu principal DIGITE 0. ");
				sair1 = scan.nextInt();
				
				} while(sair1 != 0);
			break;
				
			case 2:
				int sair2 = 1;
				do {
				System.out.println("OPÇÃO 3- Consultar Cartão de Vacinação.");
				EntidadePaciente consultaPaciente = new EntidadePaciente();
				
				scan.nextLine(); 
				System.out.println("Informe o Nome do Paciente: ");
				String nomeConsulta = scan.nextLine();
				consultaPaciente.setNome(nomeConsulta);			    			    
			    new ConsultaDB().consultarPaciente(consultaPaciente);

				System.out.println("Retornar ao menu principal DIGITE 0 ou 1 para outra busca. ");
				sair2 = scan.nextInt();
				
				} while(sair2 != 0);
			   
				break;
				
			case 3:
				int sair3 = 1;
				do {
				System.out.println("OPÇÃO 3- Relatório de Vacinação.");
				new ConsultaDB().relatorioVacinacao();

				System.out.println("Retornar ao menu principal DIGITE 0. ");
				sair3 = scan.nextInt();
				
				} while(sair3 != 0);
				break;
				
			case 4:
				int sair4 = 1;
				do {
				System.out.println("OPÇÃO 4- Acompanhar Campanha de Vacinação.");
				new ConsultaDB().resultadoCampanha();
				
				System.out.println("Retornar ao menu principal DIGITE 0. ");
				sair4 = scan.nextInt();
				
				} while(sair4 != 0);
				break;
					
					
			case 9:
				System.out.println("\n\n*** Sistema encerrado. ***\n\n");
				break;
				
			default:
                System.out.println("Opção inválida. Por favor, tente novamente.");
                break; 
				
			}
			
			
			
		}
		while (selecao != 9);
		
						
	}

}
