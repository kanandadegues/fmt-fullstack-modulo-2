package ListaDeAlunos;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercicio {

    public static void main(String[] args) {

        ArrayList<String> listaAlunos = new ArrayList<>();

        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o nome do aluno(a) ou fim para finalizar");
        String nomeDigitado = entrada.next();

        while(!nomeDigitado.equalsIgnoreCase("fim")){
            System.out.println("Digite nome do aluno ou fim para finalizar");
            nomeDigitado = entrada.next();
        }

    }
}
