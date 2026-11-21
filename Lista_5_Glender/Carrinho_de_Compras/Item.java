package Carrinho_de_Compras;

public class Item {
    private Produto produto;
    private int quantidade;
    private double valorTotal;

    public Item(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        calcularTotal();
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
        calcularTotal();
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        calcularTotal();
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void calcularTotal() {
        valorTotal = produto.getPreco() * quantidade;
    }

    public void exibirItem() {
        System.out.printf("%s | Quantidade: %d | O Total: R$ %.2f%n", produto.getNome(), quantidade, valorTotal);
    }
}
