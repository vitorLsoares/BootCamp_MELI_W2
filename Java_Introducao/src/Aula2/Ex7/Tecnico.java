package Aula2.Ex7;

import Teoria.Pessoa;

public class Tecnico extends CLT<Tecnico>{

    private double meta = 0;
    private double salarioUltimoMes;
    private final double BONIFICACAO = 0.05;
    private final int JORNADA_SEMANAL = 40;
    private final int SALARIO_BASE = 3200;
    private final boolean DESCANSO_REMUNERADO = false;
    private final int DESCANSO_REMUNERADO_H = 0;

    public Tecnico(String nome, Integer matricula, String CPF) {

        super(nome, matricula, CPF);
    }

    public double getSalarioUltimoMes() {
        return salarioUltimoMes;
    }

    public void setSalarioUltimoMes(double salarioUltimoMes) {
        this.salarioUltimoMes = salarioUltimoMes;
    }

    public double getMeta() {
        return meta;
    }

    public void setMeta(double meta) {
        this.meta = meta;
    }

    @Override
    double pagarSalario(Tecnico o) {

        double salario = 0;

        if(DESCANSO_REMUNERADO)
            salario = SALARIO_BASE + (o.getMeta() * BONIFICACAO) + (DESCANSO_REMUNERADO_H*(SALARIO_BASE/JORNADA_SEMANAL));
        else
            salario = SALARIO_BASE + (o.getMeta() * BONIFICACAO);

        o.setSalarioUltimoMes(salario);
        return salario;
    }

    @Override
    public String toString() {
        return "O Tecnico "+ super.getNome() +
                " bateu " + this.meta + " das metas " +
                "e seu ultimo salario do Mes foi de " + this.salarioUltimoMes +
                '\n';
    }
}
