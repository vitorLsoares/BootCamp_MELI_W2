package Aula1;

import java.util.Scanner;

public class Ex3 {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        int num, divisor = 0;
        System.out.print("Qual o valor do numero:");
        num = console.nextInt();

        for (int i = 1; i <= num; i++) {
            if(num % i == 0){
                divisor++;
            }
        }

        if (divisor == 2 ){
            System.out.print("Esse numero é um primo");
        }
        else {
            System.out.print("Esse numero é nao um primo");
        }
    }
}
