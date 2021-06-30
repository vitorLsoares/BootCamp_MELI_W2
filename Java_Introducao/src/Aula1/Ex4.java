package Aula1;

import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        int num,j = 0,divisor=0;
        System.out.print("Qual o valor do numero:");
        num = console.nextInt();


        for (int i = 0; i < num; i++) {
            divisor = 0;

            for (j = 1; j <= i; j++){
                if(i % j == 0){
                    divisor++;
                }
            }

            if ( divisor == 2 ){
                System.out.print("Os numeros sao:" + i + '\n');
            }
        }



    }
}
