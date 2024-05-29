package model;

public class ContaCorrente extends Conta{

    public ContaCorrente(Cliente cliente, Banco banco) {
		super(cliente, banco, "Conta Corrente");
        banco.adicionarConta(this);
	}

    @Override
    public void imprimirExtrato() {
        System.out.println("==> Extrato: Conta Corrente <==");
        super.imprimirInfosComuns();
    }
    
}
