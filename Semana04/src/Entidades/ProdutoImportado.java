package Entidades;

public class ProdutoImportado extends Produto {
    private double taxa;
    public ProdutoImportado(String nome, double preco, char tipo, double taxa) {
        super(nome, preco, tipo);
        this.taxa = taxa;
    }

    @Override
    public String mostrarProduto() {
        return super.mostrarProduto() + "Taxa: R$ " + taxa;
    }

    @Override
    public String toString() {
        return "Nome " + getNome() + "Preço R$ " + (getPreco()+taxa) + "Taxa: R$ " + taxa;
    }
}
