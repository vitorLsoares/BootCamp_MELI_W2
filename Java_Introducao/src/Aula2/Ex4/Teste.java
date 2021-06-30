package Aula2.Ex4;

public class Teste {
    public static void main(String[] args) {
        Fracao calculadora = new Fracao();

        double Divisor = calculadora.somar(2,3,5,6);
        double num = calculadora.somar(2,3,4);
        System.out.println("esse é o somar de um jeito: " + Divisor + '\n' +"esse é o somar de outro jeito: " + num  );
    }
}
