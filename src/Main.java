import model.Banco;
import model.Cliente;
import model.Conta;
import model.ContaCorrente;
import model.ContaPoupanca;

public class Main {

    public static void main(String[] args) {

        // Conta Corrente
        Cliente cliente1 = new Cliente("Mario");
        Banco banco = new Banco("Banco Inter");

        Conta contaCorrenteCliente1 = new ContaCorrente(cliente1, banco);

        try {
            contaCorrenteCliente1.depositar(250);
            contaCorrenteCliente1.sacar(100);
            contaCorrenteCliente1.imprimirExtrato();
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        }

        // Conta poupança
        Cliente cliente2 = new Cliente("Alexandre");

        Conta contaPoupancaCliente2 = new ContaPoupanca(cliente2, banco);

        try {
            contaPoupancaCliente2.depositar(500);
            contaPoupancaCliente2.sacar(400);
            contaPoupancaCliente2.imprimirExtrato();
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        }

        // Listar contas do banco
        banco.imprimirContas();

        // transferencia entre contas
        try {
            contaCorrenteCliente1.transferir(50, contaPoupancaCliente2);
            // imprimir novos valores
            contaCorrenteCliente1.imprimirExtrato();
            contaPoupancaCliente2.imprimirExtrato();
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        }
    }
}
