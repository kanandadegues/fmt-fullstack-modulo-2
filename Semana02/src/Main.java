import Entidades.Produtos;

public class Main {
    public static void main(String[] args) {

        Produtos produto = new Produtos("Celular", 2500.00, 20);
        produto.adicionarProdutos(4);
    }
}