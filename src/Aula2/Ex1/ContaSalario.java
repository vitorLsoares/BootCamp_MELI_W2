package Aula2.Ex1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ContaSalario extends Conta implements DepositoService{


    private final double TAXA_OPERACAO = 0.45;

    public ContaSalario(String numConta, int agencia, double saldo) {
        super(numConta, agencia, saldo);
    }

    @Override
    public void imprimeExtrato() {
        System.out.println("### Extrato da Conta Salario ###");

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/aaaa HH:mm:ss");
        Date date = new Date();

        System.out.println("Conta: "+this.getNumConta());
        System.out.println("Saldo: "+this.getSaldo());
        System.out.println("Data: "+sdf.format(date) + '\n'+'\n');

    }
    @Override
    public void depositar(double valor) {

    }
}
