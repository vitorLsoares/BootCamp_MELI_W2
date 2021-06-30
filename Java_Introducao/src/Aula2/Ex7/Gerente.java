package Aula2.Ex7;

public class Gerente extends CLT<Gerente>{

    private double meta = 0;
    private double salarioUltimoMes;
    private final double BONIFICACAO = 0.125;
    private final int JORNADA_SEMANAL = 36;
    private final int SALARIO_BASE = 6000;
    private final boolean DESCANSO_REMUNERADO = true;
    private final int DESCANSO_REMUNERADO_H = 4;

    public Gerente(String nome, Integer matricula, String CPF) {
        super(nome, matricula, CPF);
    }

    @Override
    double pagarSalario(Gerente o) {
        double salario = 0;

        if(DESCANSO_REMUNERADO)
            salario = SALARIO_BASE + (o.getMeta() * BONIFICACAO) + (DESCANSO_REMUNERADO_H*(SALARIO_BASE/JORNADA_SEMANAL));
        else
            salario = SALARIO_BASE + (o.getMeta() * BONIFICACAO);

        o.setSalarioUltimoMes(salario);
        return salario;
    }

    public double getMeta() {
        return meta;
    }

    public void setMeta(double meta) {
        this.meta = meta;
    }

    public double getSalarioUltimoMes() {
        return salarioUltimoMes;
    }

    public void setSalarioUltimoMes(double salarioUltimoMes) {
        this.salarioUltimoMes = salarioUltimoMes;
    }

    @Override
    public String toString() {
        return "O Gerente "+ super.getNome() +
                " bateu " + this.meta + " das metas " +
                "e seu ultimo salario do Mes foi de " + this.salarioUltimoMes +
                '\n';
    }
}
