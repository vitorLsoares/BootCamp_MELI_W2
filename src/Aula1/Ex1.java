package Aula1;

import java.util.Arrays;
import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        //============== vitrola
        System.out.print("Insira um número: ");
        int input = console.nextInt();
        int[] numerosPares = new int[10];
        int j = 0;

        for(int i = 0; i < input ; i++){

            if ( i%2 == 0){
                numerosPares[j] = i;
                j++;
            }
        }
        System.out.println(Arrays.toString(numerosPares));

        //================ rhames
//        System.out.print("Insira um número: ");
//        int numero = console.nextInt();
//        int j = 0;
//        for(int i=0;i<numero;i++){
//            while (j % 2 != 0){
//                j++;
//            }
//            System.out.println((i + 1) + " = " + j);
//            j++;
//        }


    }
}
