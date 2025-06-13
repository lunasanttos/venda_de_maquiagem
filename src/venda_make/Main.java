package venda_make;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Venda venda = new Venda();
        int opcao;

        do {
            System.out.println("\n MENU PRINCIPAL ");
            System.out.println("1. Adicionar Maquiagem para a Pele");
            System.out.println("2. Adicionar Maquiagem para os Olhos");
            System.out.println("3. Listar Produtos Escolhidos");
            System.out.println("4. Ver Total da Venda do Cliente");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> menuPele(sc, venda);
                case 2 -> menuOlhos(sc, venda);
                case 3 -> venda.listarProdutos();
                case 4 -> System.out.printf("Total da Venda: R$ %.2f%n", venda.calcularTotal());
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        sc.close();
    }

    private static void menuPele(Scanner sc, Venda venda) {
        String continuar = "s";

        do {
            System.out.println("\n Maquiagens de Pele ");
            TipoMaquiagemPele[] tipos = TipoMaquiagemPele.values();

            for (int i = 0; i < tipos.length; i++) {
                System.out.printf("%d. %s%n", i + 1, tipos[i].name().replace("_", " "));
            }

            System.out.print("Escolha o tipo: ");
            int escolha = sc.nextInt();
            sc.nextLine();

            if (escolha < 1 || escolha > tipos.length) {
                System.out.println("Tipo inválido!");
                continue;
            }

            TipoMaquiagemPele tipo = tipos[escolha - 1];

            System.out.print("Nome do produto: ");
            String nome = sc.nextLine();

            System.out.print("Preço: ");
            double preco = sc.nextDouble();
            sc.nextLine();

            MaquiagemPele m = new MaquiagemPele(nome, preco, tipo);
            venda.adicionarProduto(m);

            System.out.println("Produto de pele adicionado com sucesso!");
            System.out.print("Deseja adicionar outro produto de pele? (s/n): ");
            continuar = sc.nextLine();

        } while (continuar.equalsIgnoreCase("s"));
    }

    private static void menuOlhos(Scanner sc, Venda venda) {
        String continuar = "s";

        do {
            System.out.println("\n Maquiagens de Olhos ");
            TipoMaquiagemOlhos[] tipos = TipoMaquiagemOlhos.values();

            for (int i = 0; i < tipos.length; i++) {
                System.out.printf("%d. %s%n", i + 1, tipos[i].name().replace("_", " "));
            }

            System.out.print("Escolha o tipo: ");
            int escolha = sc.nextInt();
            sc.nextLine();

            if (escolha < 1 || escolha > tipos.length) {
                System.out.println("Tipo inválido!");
                continue;
            }

            TipoMaquiagemOlhos tipo = tipos[escolha - 1];

            System.out.print("Nome do produto: ");
            String nome = sc.nextLine();

            System.out.print("Preço: ");
            double preco = sc.nextDouble();
            sc.nextLine();

            MaquiagemOlhos m = new MaquiagemOlhos(nome, preco, tipo);
            venda.adicionarProduto(m);

            System.out.println("Produto de olhos adicionado com sucesso!");
            System.out.print("Deseja adicionar outro produto de olhos? (s/n): ");
            continuar = sc.nextLine();

        } while (continuar.equalsIgnoreCase("s"));
    }
}
