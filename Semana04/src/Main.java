import Entidades.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Quantos produtos você deseja cadastrar?");
        Scanner scan = new Scanner(System.in);
        int numero = scan.nextInt();
        Produto[] vetorProdutos = new Produto[numero];

        for (int p = 0; p < vetorProdutos.length; p++){
            System.out.println("Produto " + (p+1));
            System.out.println("Digite o nome do produto");
            scan.nextLine(); // reseta o "enter" que foi dado no nextInt anterior
            String nomeCadastro = scan.nextLine();
            System.out.println("Preço do produto");
            Double precoCadastro = scan.nextDouble();
            System.out.println("Seu produto é importado(i), usado (u) ou outra opção (c)? Coloque apenas a letra correspondente");
            char tipoProduto = scan.next().charAt(0);

            switch (tipoProduto) {
                case 'i' -> {
                    System.out.println("Qual é a taxa alfandegária do produto?");
                    Double txAlfandegariaCadastro = scan.nextDouble();
                    vetorProdutos[p] = new ProdutoImportado(nomeCadastro, precoCadastro,tipoProduto, txAlfandegariaCadastro);
                }
                case 'u' -> {
                    System.out.println("Qual é a data de fabricação do produto?");
                    String dtFabricacaoCadastro = scan.next();
                    vetorProdutos[p] = new ProdutoUsado(nomeCadastro, precoCadastro,tipoProduto, dtFabricacaoCadastro);
                }
                case 'c' -> vetorProdutos[p] = new Produto(nomeCadastro, precoCadastro, tipoProduto);
                default -> System.out.println("Entrada incorreta. Cadastro inválido");
            }
        }

        System.out.println("Entre com o número de produtos:" + numero);
        for (int i = 0; i < vetorProdutos.length; i++){
            System.out.println(vetorProdutos[i].toString());
        }
        System.out.println("Amostragem de preço dos produtos:" + "\n");
        for (int j = 0; j < vetorProdutos.length; j++){
            System.out.println(vetorProdutos[j].mostrarProduto());
        }
    }
}