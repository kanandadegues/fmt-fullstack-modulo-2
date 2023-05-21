package Modelos;

public enum Nivel {
    JUNIOR(0,"Júnior"),
    PLENO(1, "Pleno"),
    SENIOR(2, "Senior");

    private final int valor;
    private final String descricao;

    Nivel(int valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }

    public int getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }
}
