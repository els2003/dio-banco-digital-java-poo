package model;

import java.util.ArrayList;
import java.util.List;

public class Banco {

    private String nome;
    private List<Conta> contas;

    public Banco(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void imprimirContas() {
        System.out.println("*** Contas do " + this.nome + " ***");
        if (this.contas.size() == 0) {
            System.out.println("Sem nenhuma conta a constar.");
        } else {
            for (Conta conta : this.contas) {
                System.out.println(
                        "Conta número: " + conta.getNumero() + " - Cliente: " + conta.cliente.getNome()
                                + " - Tipo: " + conta.tipo);
            }
        }
    }

    public void adicionarConta(Conta conta) {
        this.contas.add(conta);
    }
}
