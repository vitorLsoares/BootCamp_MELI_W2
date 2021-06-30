package Aula1;

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        Integer n;
        Integer m;

        System.out.print("Qual o valor do numero 1:");
        n = console.nextInt();
        System.out.print("Qual o valor do numero 2:");
        m = console.nextInt();

        for(Integer i = 0; i < n; i++){
            if(i%m == 0){

                System.out.print("os numeros sao:"+i+"\n");
            }
        }


    }
}
