package venda_make;

import java.util.ArrayList;

public class Venda {

    private ArrayList<Produto> produtos = new ArrayList<>();
    private static final double desconto_minimo = 100.0;
    private static final double percentual_de_desconto = 10.0; // 10%

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto adicionado.");
        } else {
            for (Produto produto : produtos) {
                System.out.println(produto);
            }
        }
    }

    public double calcularTotal() {
        double totalBruto = 0;
        for (Produto produto : produtos) {
            totalBruto += produto.getPreco();
        }

        if (totalBruto >= desconto_minimo) {
            double desconto = totalBruto * (percentual_de_desconto / 100);
            System.out.printf("Desconto de %.0f%% aplicado: - R$ %.2f%n", percentual_de_desconto, desconto);
            return totalBruto - desconto;
        }

        return totalBruto;
    }
}
