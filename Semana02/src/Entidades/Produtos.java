package Entidades;

public class Produtos {
    private String nomeProduto;
    private double precoProduto;
    private int quantidadeProduto;

    public Produtos(String nomeProduto, double precoProduto, int quantidadeProduto) {
        this.nomeProduto = nomeProduto;
        this.precoProduto = precoProduto;
        this.quantidadeProduto = quantidadeProduto;
    }

    public void adicionarProdutos(int qtdAdicionada){
        this.quantidadeProduto += qtdAdicionada;
        System.out.println("Foram adicionados " + qtdAdicionada + " produtos ao estoque.");
    }
}
