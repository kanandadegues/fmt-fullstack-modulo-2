package Modelos;

public class Cargo {
    private String descricao;
    private double salarioBase;
    private Nivel nivel;

    public Cargo(String descricao, double salarioBase, Nivel nivel) {
        this.descricao = descricao;
        this.salarioBase = salarioBase;
        this.nivel = nivel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }
}
