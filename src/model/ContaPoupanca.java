package model;

public class ContaPoupanca extends Conta{

    public ContaPoupanca(Cliente cliente, Banco banco) {
		super(cliente, banco, "Conta Poupança");
        banco.adicionarConta(this);
	}

    @Override
    public void imprimirExtrato() {
        System.out.println("==> Extrato: Conta Poupança <==");
        super.imprimirInfosComuns();
    }

}
