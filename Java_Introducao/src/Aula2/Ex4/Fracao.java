package Aula2.Ex4;

public class Fracao {

    public double somar(int numerador1 ,int denominador1,int numerador2,int denominador2  ){
        return ((double)numerador1/denominador1 + (double)numerador2/denominador2);
    }
    public double dividir(int numerador1 ,int denominador1,int numerador2,int denominador2  ){
        return ((double)numerador1/denominador1 / (double)numerador2/denominador2);
    }
    public double subitrair(int numerador1 ,int denominador1,int numerador2,int denominador2  ){
        return ((double)numerador1/denominador1 - (double)numerador2/denominador2);
    }

    public double multiplicar(int numerador1 ,int denominador1,int numerador2,int denominador2  ){
        return ((double)numerador1/denominador1 * (double)numerador2/denominador2);
    }

    public double somar(int numerador1 ,int denominador1,int num){
        return (double) numerador1/denominador1 + num;
    }

    public double multiplicar(int numerador1 ,int denominador1,int num){
        return (double) numerador1/denominador1 * (num);
    }



}
