package Aula1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {


        Integer[] array = {52,10,85,1324,01,13,62,30,12,127};

        Scanner console = new Scanner(System.in);
        System.out.println("Escolha a opçao para ordenar o vetor:\n\n" +
                "1 - Ordenação Crescente\n" +
                "2 - Ordenação Decrescente" );

        int opicao = console.nextInt();

        switch (opicao){
            case 1 : // Ordenaçao Crescente
                Arrays.sort(array);
                System.out.print(Arrays.toString(array));
                break;
            case 2 : //Ordenacao Decrescente
                Arrays.sort(array, Collections.reverseOrder());
                System.out.print(Arrays.toString(array));
                break;
        }



        //A)

    }
}
