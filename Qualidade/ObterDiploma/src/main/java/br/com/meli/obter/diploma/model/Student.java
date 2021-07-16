package br.com.meli.obter.diploma.model;


import org.springframework.lang.NonNull;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

public class Student {

    @NonNull
    @Size(min=8,max=50,message = "Um nome deve ter no Mínimo 8 caracteres, Máximo 50 caracteres")
    @Pattern(regexp = "[a-zA-Z\" \"]+" , message = "Um nome deve conter Apenas Letras e espaços")
    private final String nome;

    private List<@Valid Subject> subjects;



    public Student(String nome, List<Subject> subjects) {
        this.nome = nome;
        this.subjects = subjects;
    }
    public Student(){
        nome = null;
    }

    public String getNome() {
        return nome;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return nome.equals(student.nome) && Objects.equals(subjects, student.subjects);
    }

}
