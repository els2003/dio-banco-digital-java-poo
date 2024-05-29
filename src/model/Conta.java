package model;

import model.interfaces.ContaInterface;

public abstract class Conta implements ContaInterface {

    private static final int AGENCIA_PADRAO = 1;
	private static int sequencial = 1;

    protected Banco banco;
    protected String tipo;
	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;

    public Conta(Cliente cliente, Banco banco, String tipoDeConta) {
        this.banco = banco;
        this.tipo = tipoDeConta;
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = sequencial++;
		this.cliente = cliente;
	}

    @Override
	public void sacar(double valor) {

        if(saldo >= valor) {
            saldo -= valor;
        } else {
            throw new IllegalArgumentException(this.cliente.getNome() + " tentou sacar ou transferir um valor maior que o seu saldo.");
        }
	}

	@Override
	public void depositar(double valor) {

		if(valor >= 0) {
            saldo += valor;
        } else {
            throw new IllegalArgumentException(this.cliente.getNome() + " tentou depositar um valor negativo.");
        }
	}

	@Override
	public void transferir(double valor, ContaInterface contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
	}

    public String getBanco() {
        return this.banco.getNome();
    }

	public int getAgencia() {
		return this.agencia;
	}

	public int getNumero() {
		return this.numero;
	}

	public double getSaldo() {
		return this.saldo;
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Banco: %s", this.banco.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
}    
