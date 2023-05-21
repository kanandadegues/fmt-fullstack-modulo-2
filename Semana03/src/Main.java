import Modelos.Cargo;
import Modelos.Colaborador;
import Modelos.Nivel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;

public class Main {

    static ArrayList<Colaborador> colaboradores = new ArrayList<>();
    static ArrayList<Cargo> cargos = new ArrayList<>();

    public static void main(String[] args) {

        cargos.add(new Cargo("Desenvolvedor Front-End", 3000.0, Nivel.JUNIOR));
        cargos.add(new Cargo("Desenvolvedor Front-End", 5000.0, Nivel.PLENO));
        cargos.add(new Cargo("Desenvolvedor Front-End", 8000.0, Nivel.SENIOR));

        colaboradores.add((new Colaborador("Pedro", new Date(), cargos.get(0))));
        colaboradores.add((new Colaborador("João", new Date(), cargos.get(1))));
        colaboradores.add((new Colaborador("Maria", new Date(), cargos.get(2))));

        for (Colaborador colaborador : colaboradores) {
            if (colaborador.getDtDesligamento() == null) {
                System.out.println(colaborador);
            }
        }

        for (Cargo cargo : cargos) {
            System.out.println("Lista de colaboradores de cargo: " + cargo);
            for (Colaborador colaborador : colaboradores) {
                if (colaborador.getCargo() == cargo) {
                    System.out.println(colaborador);
                }
            }
        }

        Colaborador colaborador = adicionarNovoColaborador();
        if (colaborador != null) {
            admitirColaborador(colaborador);
        }

        desligarColaborador();
    }

    public static void admitirColaborador(Colaborador colaborador) {
        colaboradores.add(colaborador);
    }

    public static Colaborador adicionarNovoColaborador() {
        String nome = JOptionPane.showInputDialog(null, "Digite o nome do colaborador");
        Date dtAdminissao = new Date();
        Cargo cargo = (Cargo) JOptionPane.showInputDialog(
                null,
                "Selecione um cargo",
                "Seleção de cargo",
                JOptionPane.PLAIN_MESSAGE,
                null,
                cargos.toArray(),
                cargos.get(0)
        );
        Colaborador colaborador = new Colaborador(nome, dtAdminissao, cargo);
        return colaborador;
    }

    public static void desligarColaborador(){
        JOptionPane.showMessageDialog(null, "Desligar colaborador");

        Colaborador colaborador = (Colaborador) JOptionPane.showInputDialog(
                null,
                "Selecione o colaborador",
                "Selecione o colaborador",
                JOptionPane.PLAIN_MESSAGE,
                null,
                colaboradores.toArray(),
                colaboradores.get(0)

        );

        colaborador.setDtDesligamento(new Date());
    }
}