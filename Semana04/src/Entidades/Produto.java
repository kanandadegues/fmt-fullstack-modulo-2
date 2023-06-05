package Entidades;

public class Produto {
    private String nome;
    private double preco;
    private char tipo;

    public Produto(String nome, double preco, char tipo) {
        this.nome = nome;
        this.preco = preco;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public String mostrarProduto(){
        return nome + "R$" + preco;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                ", tipo=" + tipo +
                '}';
    }
}
