package Aula2.Ex1;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Conta {

    private String numConta;
    private int agencia;
    private double saldo;


    //Construtor


    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/aaaa HH:mm:ss");
        Date date = new Date();

        return "### Extrato da Conta Salário ###" + '\n' +
                "Conta:" + numConta + '\n' +
                "Agencia:" + agencia + '\n'+
                "Saldo:" + saldo + '\n' +
                "Data = "+ sdf.format(date) + '\n' + '\n'
                ;
    }

    public Conta(String numConta, int agencia, double saldo) {
        this.numConta = numConta;
        this.agencia = agencia;
        this.saldo = saldo;
    }

    //Interface
    public abstract void imprimeExtrato();

    private void devolucao(){

    }


    //Métodos Getter and Setter
    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public String getNumConta() {
        return numConta;
    }

    public void setNumConta(String numConta) {
        this.numConta = numConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
