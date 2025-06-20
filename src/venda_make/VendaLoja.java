package venda_make;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class VendaLoja {
    private ArrayList<Produto> produtos = new ArrayList<>();

    public void adicionarProduto(Produto p) {
        produtos.add(p);
    }

    public void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        System.out.println("Produtos cadastrados:");
        for (Produto p : produtos) {
            System.out.println(p);
        }
    }

    public void registrarVenda(Scanner sc) {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        ArrayList<Produto> vendaAtual = new ArrayList<>();
        double total = 0;
        String continuar;

        do {
            try {
                System.out.println("Escolha um produto para vender:");
                for (int i = 0; i < produtos.size(); i++) {
                    System.out.println(i + " - " + produtos.get(i));
                }

                System.out.print("Digite o número do produto: ");
                int escolha = sc.nextInt();
                sc.nextLine();

                if (escolha >= 0 && escolha < produtos.size()) {
                    Produto escolhido = produtos.get(escolha);
                    vendaAtual.add(escolhido);
                    total += escolhido.getPreco();
                    System.out.println(escolhido.getNome() + " adicionado à venda.");
                } else {
                    System.out.println("Número fora da faixa de produtos cadastrados.");
                }

                System.out.print("Deseja adicionar outro produto? (s/n): ");
                continuar = sc.nextLine().toLowerCase();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Digite um número válido.");
                sc.nextLine();
                continuar = "s";
            }
        } while (continuar.equals("s"));


        System.out.println("\nResumo da venda:");
        for (Produto p : vendaAtual) {
            System.out.println(p);
        }
        System.out.printf("Total da venda: R$%.2f%n", total);
    }
}
