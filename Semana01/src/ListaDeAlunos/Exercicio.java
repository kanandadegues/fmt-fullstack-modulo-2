package ListaDeAlunos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Exercicio {

    public static void main(String[] args) {

        ArrayList<String> listaAlunos = new ArrayList<>();
        ArrayList<double[]> listaNotas = new ArrayList<>();

        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o nome do aluno(a) ou fim para finalizar");
        String nomeDigitado = entrada.next();

        while(!nomeDigitado.equalsIgnoreCase("fim")){

            listaAlunos.add(nomeDigitado);

            System.out.println("Digite as notas do aluno(a)" + nomeDigitado);
            System.out.println("Digite a primeira nota = ");
            double n1 = entrada.nextDouble();
            System.out.println("Digite a segunda nota = ");
            double n2 = entrada.nextDouble();
            System.out.println("Digite a terceira nota = ");
            double n3 = entrada.nextDouble();

            double[] notas = new double[3];
            notas[0] = n1;
            notas[1] = n2;
            notas[2] = n3;
            listaNotas.add(notas);

            System.out.println("Digite nome do aluno(a) ou fim para finalizar");
            nomeDigitado = entrada.next();
        }

        for (int i = 0; i < listaAlunos.size(); i++){
            System.out.println("Aluno(a) " + listaAlunos.get(i));
            System.out.println("Notas " + Arrays.toString(listaNotas.get(i)));
            double totalNotas = 0.0;
            for (int n = 0; n < listaNotas.get(i).length; n++){
                totalNotas += listaNotas.get(i)[n];
            }
            double media = totalNotas / listaNotas.get(i).length;
            System.out.println("Média do aluno(a) " + listaAlunos.get(i) + " = " + media);
        }

    }
}
