package br.com.meli.obter.diploma.model;


import org.springframework.lang.NonNull;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

public class Student {

    //    @Pattern(regexp = "^((?=.*[a-z])|(?=.*[A-Z]))" , message = "Deve conter Apenas Letras")
    @NonNull
    @Size(min=8,max=50,message = "Mínimo 8 caracteres, Máximo 50 caracteres")
    @Pattern(regexp = "[a-zA-Z\" \"]+" , message = "Deve conter Apenas Letras")
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
}
