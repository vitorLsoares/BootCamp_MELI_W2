package Aula2.Ex7;

public class Main {
    public static void main(String[] args) {
        Gerente vitor = new Gerente("Vitor", 23455,"476.173.378-09");
        Diretor vitorL = new Diretor("Ricardo", 34456,"123.234.453-06");


        System.out.println("Pagamento primeiro Mes ============");
        vitorL.pagarSalario(vitorL);
        vitor.pagarSalario(vitor);
        System.out.println(vitor);
        System.out.println(vitorL);

        System.out.println("Pagamento Segundo Mes ============");
        vitor.setMeta(7689);
        vitorL.setLucro(100000);
        vitor.pagarSalario(vitor);
        System.out.println(vitorL);
        System.out.println(vitor);





    }
}
