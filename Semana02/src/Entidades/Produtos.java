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
        System.out.println("Foram adicionados " + qtdAdicionada + " produtos ao estoque. " +
                           "A quantidade total de produtos no estoque é " + quantidadeProduto);
    }

    public void removerProdutos(int qtdRemovida){
        if(quantidadeProduto < qtdRemovida){
            System.out.println("Não é possível remover uma quantidade superior ao que consta no estoque. " +
                               "O estoque atualmente conta com " + quantidadeProduto + " produtos");
            return;
        } else{
            quantidadeProduto -= qtdRemovida;
            System.out.println("Foram removidos do estoque " + qtdRemovida + " produtos e a quantidade de " +
                               "produtos atualizada é " + quantidadeProduto);
        }
    }

    public double valorTotalEstoque(){
        return quantidadeProduto * precoProduto;
    }

    @Override
    public String toString() {
        return this.nomeProduto + ", por " + this.precoProduto + " reais " + this.quantidadeProduto + " produtos em estoque." ;
    }
}
