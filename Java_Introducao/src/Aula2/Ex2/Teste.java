package Aula2.Ex2;

public class Teste {
    public static void main(String[] args) {

        Counter contador = new Counter(0);

        System.out.println(contador);

        contador.incrementar(234);
        contador.decrementar(45);
        contador.incrementar(26.43);

        System.out.println(contador);
    }
}
