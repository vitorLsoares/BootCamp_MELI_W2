package Aula2.Ex1;

public class Teste {

    public static void main(String[] args) {

        ContaCorrente cc = new ContaCorrente("12345-9",021,0.0);
        ContaSilver cs = new ContaSilver("34562-9",037,0.0);
        cs.setSaldo(1023.6);
        ContaSalario csal = new ContaSalario("80975-9",065,0.0);
        csal.setSaldo(1045.8);

        System.out.println("================== Antes da Transferencia ============");

        cc.imprimeExtrato();
        System.out.println(csal);
        cs.imprimeExtrato();

        System.out.println("================== Depois da Transferencia ============");
        cc.transferencia(cs,23.0);

        cc.imprimeExtrato();
        cs.imprimeExtrato();

        cc.depositar(600.00);
        cc.imprimeExtrato();

    }
}
