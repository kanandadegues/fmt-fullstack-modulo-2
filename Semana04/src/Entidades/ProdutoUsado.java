package Entidades;

public class ProdutoUsado extends Produto{
    private String dtFabricacao;
    public ProdutoUsado(String nome, double preco, char tipo, String dtFabricacao) {
        super(nome, preco, tipo);
        this.dtFabricacao = dtFabricacao;
    }

    public String mostrarProduto() {
        return getNome() + " (usado) " + " R$ " + getPreco() +
                " (Data de fabricação: " + dtFabricacao + ")";
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Data de fabricação (DD/MM/YYYY): " + dtFabricacao;
    }
}
