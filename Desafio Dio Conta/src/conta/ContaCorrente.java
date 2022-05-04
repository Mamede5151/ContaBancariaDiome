package conta;

import Utilitarios.Utils;

public class ContaCorrente {
	
	private static int contadorDeContas = 1;
	
	private int numeroConta;
	private Pessoa pessoa;	
	private Double saldo=0.0;
	public ContaCorrente(int numeroConta, Pessoa pessoa, Double saldo) {
	
		this.numeroConta = contadorDeContas;
		this.pessoa = pessoa;
		contadorDeContas += 1;
	}
	public int getNumeroConta() {
		return numeroConta;
	}
	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	public String toString() {
		return "\nN�mero da conta: " + this.getNumeroConta()+
				"\nNome: " + this.pessoa.getNome() +
				"\nCpf: " + this.pessoa.getCpf() +
				"\nEmail: " + this.pessoa.getEmail() +
				"\nSaldo: " + Utils.doubleToString(this.getSaldo())+
				"\n";
				
	}
	
	public void depositar(Double valor) {
		if(valor >0) {
			setSaldo(getSaldo() + valor);
			System.out.println("Seu dep�sito foi realizado com sucesso!");
		}else {
			System.out.println("N�o foi poss�vel realizar o seu dep�sito!");
		}
	}
	public void sacar(Double valor) {
		if(valor>0 && this.getSaldo()>= valor) {
			setSaldo(getSaldo() - valor);
			System.out.println("Seu saque foi realizado com sucesso!");
		}else {
			System.out.println("N�o foi poss�vel realizar o seu saque!");

		}
	}
	public void transferir(ContaCorrente contaParaDeposito, Double valor) {
		if(valor>0 && this.getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);
			
			contaParaDeposito = contaParaDeposito.getSaldo() + valor;
			System.out.println("Sua transfer�ncia foi realizado com sucesso!");
		}else {
			System.out.println("N�o foi poss�vel realizar sua transfer�ncia!");

		}
	}
}