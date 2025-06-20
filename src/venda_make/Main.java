package venda_make;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        VendaLoja venda = new VendaLoja();
        int opcao = -1;

        do {
            try {
                System.out.println("\n--- MENU PRINCIPAL ---");
                System.out.println("1. Cadastrar Produto de Pele");
                System.out.println("2. Cadastrar Produto de Olhos");
                System.out.println("3. Listar Produtos");
                System.out.println("4. Realizar Venda");
                System.out.println("0. Sair");
                System.out.print("Escolha: ");
                opcao = sc.nextInt();
                sc.nextLine();

                switch (opcao) {
                    case 1:
                        System.out.print("Nome do produto: ");
                        String nomePele = sc.nextLine();

                        double precoPele = lerPreco(sc);

                        ProdutoPele pPele = new ProdutoPele(nomePele, precoPele);
                        venda.adicionarProduto(pPele);
                        pPele.vender();
                        break;

                    case 2:
                        System.out.print("Nome do produto: ");
                        String nomeOlho = sc.nextLine();

                        double precoOlho = lerPreco(sc);

                        ProdutoOlhos pOlhos = new ProdutoOlhos(nomeOlho, precoOlho);
                        venda.adicionarProduto(pOlhos);
                        pOlhos.vender();
                        break;

                    case 3:
                        venda.listarProdutos();
                        break;

                    case 4:
                        venda.registrarVenda(sc);
                        break;

                    case 0:
                        System.out.println("Saindo...");
                        break;

                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Digite um número.");
                sc.nextLine();
            }

        } while (opcao != 0);

        sc.close();
    }

    public static double lerPreco(Scanner sc) {
        double preco = -1;
        while (true) {
            try {
                System.out.print("Preço: ");
                preco = sc.nextDouble();
                sc.nextLine();
                if (preco < 0) {
                    throw new IllegalArgumentException("Preço não pode ser negativo.");
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Por favor, digite um valor numérico válido.");
                sc.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return preco;
    }
}