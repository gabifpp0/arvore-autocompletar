package arvore_binaria;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArvoreBinaria<String> arvore = new ArvoreBinaria<>();

        int opcao;
        String palavra;

        do {
            System.out.println("\n===== ÁRVORE BINÁRIA DE PALAVRAS =====");
            System.out.println("1 - Inserir palavra");
            System.out.println("2 - Remover palavra");
            System.out.println("3 - Remover por prefixo");
            System.out.println("4 - Remover por sufixo");
            System.out.println("5 - Remover por infixo");
            System.out.println("6 - Remover todas as palavras");
            System.out.println("7 - Consultar palavra");
            System.out.println("8 - Listar todas as palavras");
            System.out.println("9 - Buscar por prefixo");
            System.out.println("10 - Buscar por sufixo");
            System.out.println("11 - Buscar por infixo");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    System.out.print("Digite a palavra: ");
                    palavra = scanner.nextLine();

                    if (arvore.buscar(palavra) == null) {
                        arvore.inserir(palavra);
                        System.out.println("Palavra inserida!");
                    } else {
                        System.out.println("Palavra já existe!");
                    }
                    break;

                case 2:
                    System.out.print("Digite a palavra: ");
                    palavra = scanner.nextLine();

                    if (arvore.remover(palavra)) {
                        System.out.println("Palavra removida!");
                    } else {
                        System.out.println("Palavra não encontrada!");
                    }
                    break;

                case 3:
                    System.out.print("Digite o prefixo: ");
                    palavra = scanner.nextLine();

                    System.out.println("Removidas: "
                            + arvore.removerPorPrefixo(palavra));
                    break;

                case 4:
                    System.out.print("Digite o sufixo: ");
                    palavra = scanner.nextLine();

                    System.out.println("Removidas: "
                            + arvore.removerPorSufixo(palavra));
                    break;

                case 5:
                    System.out.print("Digite o infixo: ");
                    palavra = scanner.nextLine();

                    System.out.println("Removidas: "
                            + arvore.removerPorInfixo(palavra));
                    break;

                case 6:
                    System.out.println("Removidas: "
                            + arvore.removerTodas());
                    break;

                case 7:
                    System.out.print("Digite a palavra: ");
                    palavra = scanner.nextLine();

                    if (arvore.consultar(palavra)) {
                        System.out.println("Palavra encontrada!");
                    } else {
                        System.out.println("Palavra não encontrada!");
                    }
                    break;

                case 8:
                    System.out.println(arvore.listarEmOrdem());
                    break;

                case 9:
                    System.out.print("Digite o prefixo: ");
                    palavra = scanner.nextLine();

                    System.out.println(arvore.buscarPrefixo(palavra));
                    break;

                case 10:
                    System.out.print("Digite o sufixo: ");
                    palavra = scanner.nextLine();

                    System.out.println(arvore.buscarSufixo(palavra));
                    break;

                case 11:
                    System.out.print("Digite o infixo: ");
                    palavra = scanner.nextLine();

                    System.out.println(arvore.buscarInfixo(palavra));
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        scanner.close();
    }
}