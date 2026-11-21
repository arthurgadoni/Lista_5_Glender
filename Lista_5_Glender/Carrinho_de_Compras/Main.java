package Carrinho_de_Compras;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Produto p1 = new Produto("Teclado", 1, 120.00);
        Produto p2 = new Produto("Mouse", 2, 80.00);
        Produto p3 = new Produto("Monitor", 3, 950.00);

        Produto[] produtos = {p1, p2, p3};
        Fatura fatura = new Fatura();
        int opcao = 0;

        while (opcao != 3) {

            System.out.println("\n=== LOJA DE SUPRIMENTOS ===");
            System.out.println("1 - Comprar");
            System.out.println("2 - Ver Fatura");
            System.out.println("3 - Encerrar Programa");
            System.out.print("Qual opcao é? : ");

            if (!sc.hasNextInt()) {
                System.out.println("-Me diz uma opcao valida-");
                sc.next();
                continue;
            }

            opcao = sc.nextInt();
            switch (opcao) {

                case 1:

                    System.out.println("\n=== PRODUTOS DISPONIVEIS ===");
                    for (Produto produto : produtos) {
                        produto.exibirProduto();
                    }

                    System.out.print("\nDiga-me o codigo do produto: ");
                    if (!sc.hasNextInt()) {
                        System.out.println("-Codigo invalido-");
                        sc.next();
                        break;
                    }

                    int codigo = sc.nextInt();
                    Produto selecionado = null;
                    for (Produto produto : produtos) {
                        if (produto.getCodigo() == codigo) {
                            selecionado = produto;
                            break;
                        }
                    }

                    if (selecionado == null) {
                        System.out.println("-Produto nao encontrado-!");
                        break;
                    }

                    System.out.print("Me diga a quantidade: ");

                    if (!sc.hasNextInt()) {
                        System.out.println("-Quantidade invalida-");
                        sc.next();
                        break;
                    }

                    int quantidade = sc.nextInt();

                    fatura.adicionarItem(selecionado, quantidade);

                    break;

                case 2:

                    fatura.exibirFatura();

                    break;

                case 3:

                    System.out.println("\n|Programa encerrado|");
                    break;

                default:

                    System.out.println("-Opcao invalida-");
            }
        }

        sc.close();
    }
}
