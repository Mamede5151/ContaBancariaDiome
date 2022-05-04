package conta;

import java.util.ArrayList;
import java.util.Scanner; 
	public class Agenciabancaria {
		
	static Scanner input =new Scanner(System.in);
	static ArrayList<ContaCorrente> contasBancarias;
	
	public static void main(String[] args) {
		contasBancarias = new ArrayList<ContaCorrente>();
		operacoes();
		}
	public static void operacoes() {
		
		System.out.println("-------------------------------------------");
		System.out.println("-------------Bem vindos a Ag�ncia Dio.me!-------------");
		System.out.println("#### Selecione a op��o que deseja realizar####");
		System.out.println("## Op��o 1 - Criar conta Corrente ##");
		System.out.println("## Op��o 2 - Depositar ##");
		System.out.println("## Op��o 3 - Sacar ##");
		System.out.println("## Op��o 4 - Transferir ##");
		System.out.println("## Op��o 5 - Listar ##");
		System.out.println("## Op��o 6 -Sair##");
		
		int operacao = input.nextInt();
		switch(operacao) {
		case 1 :
			criarContaCorrente();
			break;
		case 2 :
			depositar();
			break;
		case 3:
			sacar();
			break;
		case 4:
			transferir();
			break;
		case 5:
			listarContas();
		case 6:
			System.out.println("Obrigado por usar a Ag�ncia Dio.me");
			System.exit(0);
			
			default:
				System.out.println("Op��o inv�lida!");
				operacoes();
				break;

					
		}
		
			
	}
	
	public static void criarContaCorrente() {
		System.out.println("\nNome:");
		String nome = input.next();
		
		System.out.println("\nCpf:");
		String cpf = input.next();
		
		System.out.println("\nEmail:");
		String email = input.next();
		
		Pessoa pessoa = new Pessoa(nome, cpf, email);
		
		ContaCorrente conta = new ContaCorrente(0, pessoa, null);
		
		contasBancarias.add(conta);
		System.out.println("Sua Conta foi criada com sucesso!");
		
		operacoes();
		
	}
	private static ContaCorrente encontrarConta(int numeroConta) {
		ContaCorrente conta = null;
		if(contasBancarias.size() > 0) {
			for(ContaCorrente c: contasBancarias) {
				if(c.getNumeroConta()== numeroConta);
				conta = c;
			}
		}
		return conta;
	}
	
	public static void depositar() {
		
		System.out.println("N�mero da conta: ");
		int numeroConta = input.nextInt();
		
		ContaCorrente conta= encontrarConta(numeroConta);
		
		if(conta !=null) {
			System.out.println("Qual valor deseja depoitar?");
			Double valorDeposito = input.nextDouble();
			conta.depositar(valorDeposito);
			System.out.println("Valor depositado com sucesso!");
		}else 
		{ 		System.out.println("Conta n�o encontrada, por favor tente novamente!");

	}operacoes ();
	}
	public static void sacar() {
		System.out.println("N�mero da conta: ");
		int numeroConta = input.nextInt();
		
		ContaCorrente conta= encontrarConta(numeroConta);
		
		if(conta !=null) {
			System.out.println("Qual valor deseja sacar?");
			Double valorSaque = input.nextDouble();
			conta.sacar(valorSaque);
			System.out.println("Valor sacado com sucesso!");
		}else 
			System.out.println("Conta n�o encontrada, por favor tente novamente!");

	}
		public static void transferir() {
			System.out.println("N�mero da conta do remetente: ");
			int numeroContaRemetente = input.nextInt();
			
			ContaCorrente contaRemetente = encontrarConta(numeroContaRemetente);
			if(contaRemetente != null) {
				System.out.println("N�mero da conta do destinat�rio:");
				int numeroContaDestinatario = input.nextInt();
				
				ContaCorrente contaDestinatario = encontrarConta(numeroContaDestinatario);
				if(contaDestinatario != null) {
					System.out.println("Valor da transfer�ncia");
					Double valor = input.nextDouble();
					
					contaRemetente.transferir(contaDestinatario, valor);
				}
			}
			operacoes();
			
		}
		public static void listarContas() {
			if(contasBancarias.size()>0) {
				for(ContaCorrente conta : contasBancarias) {
					System.out.println(conta);
				} 
				
				}	else {
					
					System.out.print("N�o h� contas cadastradas!");

				}
				operacoes();
				
				}
			}
		
		
		

