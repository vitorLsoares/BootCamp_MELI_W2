package br.com.meli.obter.diploma.model;

import org.springframework.lang.NonNull;

import javax.validation.constraints.*;
import java.util.Objects;

public class Subject {

    @NonNull
    @Size(min=6,max=50,message = "Um Subject deve ter no Mínimo 6 caracteres, Máximo 50 caracteres")
    @Pattern(regexp = "[a-zA-Z]+" , message = "Um subject deve conter Apenas Letras")
    private String subject;

    //@NotEmpty
    @Digits(integer = 2,fraction = 1, message = "Uma Nota deve ter no Máximo 2 digitos Inteiros e no Máximo 1 digito Decimal")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject1 = (Subject) o;
        return Double.compare(subject1.note, note) == 0 && subject.equals(subject1.subject);
    }
}
