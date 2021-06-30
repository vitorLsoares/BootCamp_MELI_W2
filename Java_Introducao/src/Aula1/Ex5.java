package Aula1;

import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        Integer i = 0,count_digit = 0,count = 1, quantidadeNumero = 0, quantidadeDigitos = 0;
        int qualDigito = 0;

        System.out.print("Quantos numeros está Buscando?\nN=");
        quantidadeNumero = console.nextInt();
        System.out.print("Quantos digitos está Buscando?\nM=");
        quantidadeDigitos = console.nextInt();
        System.out.print("Qual digito está Buscando?\nD=");
        qualDigito = console.nextInt();


        while(count  <= quantidadeNumero) {

            String numTexto = i.toString();

            for (int j = 0 ; j < numTexto.length() ; j++){
                if( Character.getNumericValue(numTexto.charAt(j)) == qualDigito ){
                    count_digit++;
                }
                if(quantidadeDigitos == count_digit){
                    count++;
                    System.out.println("O numero é:" + numTexto);
                }
            }
            count_digit = 0;
            i++;
        }
    }

}
