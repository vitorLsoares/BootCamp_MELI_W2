package br.com.meli.diploma.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Aluno {

    private String nome;
    private List<Diciplina> diciplinas = new ArrayList<Diciplina>();

    public Aluno(String nome) {

        List<Diciplina> disp = new ArrayList<Diciplina>(
                Arrays.asList(
                        new Diciplina("EDUCACAO_FISICA",0.0),
                        new Diciplina("GEOGRAFIA",0.0),
                        new Diciplina("FISICA",0.0),
                        new Diciplina("MATEMATICA",0.0),
                        new Diciplina("HISTORIA",0.0),
                        new Diciplina("QUIMICA",0.0),
                        new Diciplina("BIOLOGIA",0.0)
                )
        );

        this.nome = nome;
        this.diciplinas =  disp;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Diciplina> getDiciplinas() {
        return diciplinas;
    }

    public void setDiciplinas(List<Diciplina> diciplinas) {
        this.diciplinas = diciplinas;
    }
}
