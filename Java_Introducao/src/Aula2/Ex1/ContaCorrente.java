package Aula2.Ex1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ContaCorrente extends Conta implements DepositoService,SaqueService,TransferenciaService{

    private final double TAXA_OPERACAO = 0.20;

    public ContaCorrente(String numConta, int agencia, double saldo) {
        super(numConta, agencia, saldo);
    }

    @Override
    public void imprimeExtrato() {
        System.out.println("### Extrato da Conta Corrente ###");

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/aaaa HH:mm:ss");
        Date date = new Date();

        System.out.println("Conta: "+this.getNumConta());
        System.out.println("Saldo: "+this.getSaldo());
        System.out.println("Data: "+sdf.format(date) + '\n'+'\n');

    }

    @Override
    public void depositar(double valor) {
         double saldoAtual = super.getSaldo();
         saldoAtual += valor - TAXA_OPERACAO;
         super.setSaldo(saldoAtual);
    }

    @Override
    public void sacar(double valor) {
        double saldoAtual = super.getSaldo();
        saldoAtual -= valor + TAXA_OPERACAO;
        super.setSaldo(saldoAtual);
    }



    @Override
    public void transferencia(Conta destino, double valor) {

        double saldoDestivo = destino.getSaldo();
        double saldoOrigem = super.getSaldo();

        saldoDestivo += valor;
        saldoOrigem -= valor;

        destino.setSaldo(saldoDestivo);
        super.setSaldo(saldoOrigem);


    }
}
