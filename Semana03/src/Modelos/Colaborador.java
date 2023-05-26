package Modelos;

import java.util.Date;

public class Colaborador {
    private String nome;
    private Date dtAdmissao;
    private Date dtDesligamento;
    private Cargo cargo;
    private double salario;

    public Colaborador(String nome, Date dtAdmissao, Cargo cargo) {
        this.nome = nome;
        this.dtAdmissao = dtAdmissao;
        this.cargo = cargo;
        this.salario = cargo.getSalarioBase();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDtAdmissao() {
        return dtAdmissao;
    }

    public void setDtAdmissao(Date dtAdmissao) {
        this.dtAdmissao = dtAdmissao;
    }

    public Date getDtDesligamento() {
        return dtDesligamento;
    }

    public void setDtDesligamento(Date dtDesligamento) {
        this.dtDesligamento = dtDesligamento;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Colaborador{" +
                "nome='" + nome + '\'' +
                ", dtAdmissao=" + dtAdmissao +
                ", dtDesligamento=" + dtDesligamento +
                ", cargo=" + cargo +
                ", salario=" + salario +
                '}';
    }
}

