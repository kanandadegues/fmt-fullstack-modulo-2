import Modelos.Cargo;
import Modelos.Colaborador;
import Modelos.Nivel;

import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        ArrayList<Colaborador> colaboradores = new ArrayList<>();
        ArrayList<Cargo> cargos = new ArrayList<>();

        cargos.add(new Cargo("Desenvolvedor Front-End", 3000.0, Nivel.JUNIOR));
        cargos.add(new Cargo("Desenvolvedor Front-End", 5000.0, Nivel.PLENO));
        cargos.add(new Cargo("Desenvolvedor Front-End", 8000.0, Nivel.SENIOR));

        colaboradores.add((new Colaborador("Pedro", new Date(), cargos.get(0))));
        colaboradores.add((new Colaborador("João", new Date(), cargos.get(1))));
        colaboradores.add((new Colaborador("Maria", new Date(), cargos.get(2))));

        for (Colaborador colaborador : colaboradores){
            if (colaborador.getDtDesligamento() == null){
                System.out.println(colaborador);
            }
        }

        for (Cargo cargo: cargos){
            System.out.println("Lista de colaboradores de cargo: " + cargo);
            for (Colaborador colaborador: colaboradores){
                if (colaborador.getCargo() == cargo){
                    System.out.println(colaborador);
                }
            }
        }
    }
}