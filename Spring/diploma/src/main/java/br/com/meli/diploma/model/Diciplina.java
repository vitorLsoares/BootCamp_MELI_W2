package br.com.meli.diploma.model;

public class Diciplina {

    private String diciplina;
    private double nota;

    public Diciplina(String diciplina, double nota) {
        this.diciplina = diciplina;
        this.nota = nota;
    }

    public Diciplina() {
    }

    public String getDiciplina() {
        return diciplina;
    }

    public void setDiciplina(String diciplina) {
        this.diciplina = diciplina;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

}
