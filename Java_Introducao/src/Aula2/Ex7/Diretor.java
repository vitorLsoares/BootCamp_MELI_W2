package Aula2.Ex7;

public class Diretor extends CLT<Diretor>{

    private double lucro = 0;
    private double salarioUltimoMes;
    private final int JORNADA_SEMANAL = 36;
    private final boolean DESCANSO_REMUNERADO = false;
    private final int DESCANSO_REMUNERADO_H = 0;
    private final double BONIFICACAO = 0.03;
    private final int SALARIO_BASE = 15000;

    public Diretor(String nome, Integer matricula, String CPF) {
        super(nome, matricula, CPF);
    }

    @Override
    double pagarSalario(Diretor o) {
        double salario = 0;

        if(DESCANSO_REMUNERADO)
            salario = SALARIO_BASE + (o.getLucro() * BONIFICACAO) + (DESCANSO_REMUNERADO_H*(SALARIO_BASE/JORNADA_SEMANAL));
        else
            salario = SALARIO_BASE + (o.getLucro() * BONIFICACAO);

        o.setSalarioUltimoMes(salario);
        return salario;
    }

    public double getLucro() {
        return lucro;
    }

    public void setLucro(double lucro) {
        this.lucro = lucro;
    }

    public double getSalarioUltimoMes() {
        return salarioUltimoMes;
    }

    public void setSalarioUltimoMes(double salarioUltimoMes) {
        this.salarioUltimoMes = salarioUltimoMes;
    }

    @Override
    public String toString() {
        return "O diretor "+ super.getNome() +
                " de acordo com " + this.lucro + " lucro do mes " +
                "e seu ultimo salario do Mes foi de " + this.salarioUltimoMes +
                '\n';
    }
}
