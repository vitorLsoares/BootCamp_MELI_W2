package br.com.meli.obter.diploma.model;

import org.springframework.lang.NonNull;

import javax.validation.constraints.*;

public class Subject {

    @NonNull
    @Size(min=6,max=50,message = "Mínimo 8 caracteres, Máximo 50 caracteres")
    @Pattern(regexp = "[a-zA-Z]+" , message = "Deve conter Apenas Letras")
    private String subject;

    //@NotEmpty
    @Digits(integer = 2,fraction = 1, message = "Mínimo 1 caracteres, Máximo 2 caracteres")
    @DecimalMax("10.0")
    @DecimalMin("0.0")
    private double note;

    public Subject(String subject, double note) {
        this.subject = subject;
        this.note = note;
    }

    public Subject(){
        subject = null;
        //note = null;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }
}
