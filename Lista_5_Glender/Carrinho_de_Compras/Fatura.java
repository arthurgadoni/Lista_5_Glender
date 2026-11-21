package Carrinho_de_Compras;

import java.util.ArrayList;

public class Fatura {
    private ArrayList<Item> itens;
    private double valorTotal;

    public Fatura() {
        itens = new ArrayList<>();
        valorTotal = 0;
    }

    public ArrayList<Item> getItens() {
        return new ArrayList<>(itens);
    }

    public void setItens(ArrayList<Item> itens) {
        this.itens = new ArrayList<>(itens);
        calcularTotal();
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void adicionarItem(Produto produto, int quantidade) {
        if (quantidade <= 0) {
            System.out.println("-Quantidade invalida-");
            return;
        }

        Item item = new Item(produto, quantidade);
        itens.add(item);
        calcularTotal();
        System.out.println("Produto adicionado ao carrinho!");
    }

    public void calcularTotal() {
        valorTotal = 0;
        for (Item item : itens) {
            valorTotal += item.getValorTotal();
        }
    }

    public void exibirFatura() {
        System.out.println("\n=== FATURA DA COMPRA ===");
        if (itens.size() == 0) {
            System.out.println("Nenhum produto comprado ainda, entao compra po");
            return;
        }

        for (Item item : itens) {
            item.exibirItem();
        }

        calcularTotal();
        System.out.println("-------------------------");
        System.out.printf("VALOR FINAL É: R$ %.2f%n", valorTotal);
    }
}
