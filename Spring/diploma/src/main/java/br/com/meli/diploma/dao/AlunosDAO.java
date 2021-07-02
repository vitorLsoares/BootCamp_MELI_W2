package br.com.meli.diploma.dao;

import br.com.meli.diploma.model.Aluno;
import br.com.meli.diploma.model.Diciplina;

import java.util.*;

public class AlunosDAO {

    private static List<Aluno> alunos = new ArrayList<Aluno>(
            Arrays.asList(
                    new Aluno("Vitor"),
                    new Aluno("Adalberto"),
                    new Aluno("Joao"),
                    new Aluno("Carlos"),
                    new Aluno("Rodrigues"),
                    new Aluno("Ruan"),
                    new Aluno("Romario"),
                    new Aluno("Gilberto"),
                    new Aluno("Maria Julia")
            )
    );


    public List<Aluno> getSala(){
        return alunos;
    }

    public void adicionarAluno(Aluno aluno){
        alunos.add(aluno);
    }

    public boolean adicionarNota(Aluno aluno, String diciplina, double nota){

        Optional<Diciplina> disciplinaOpt = aluno.getDiciplinas().stream().filter(d -> d.getDiciplina().equalsIgnoreCase(diciplina)).findFirst();

        if(disciplinaOpt.isPresent()){
            disciplinaOpt.get().setNota(nota);
            return true;
        }

        return false;

    }

    public String calculoDiploma(Aluno aluno){
        double nota = 0;
        nota = aluno.getDiciplinas().stream().mapToDouble(diciplina -> diciplina.getNota()).sum();
        double media = nota/aluno.getDiciplinas().size();
        if ( media > 9.0){
            return "Parabens " + aluno.getNome() + " voce é  um aluno exemplar com média de " + media;
        }
        else if (media > 5.0 && media < 9.0){
            return "Parabens " + aluno.getNome() + " voce é um bom aluno(a) com média de " + media;
        }
        return "Oi " + aluno.getNome() + " voce pode melhorar sua média foi " + media;

    }

    public Aluno get(String nome){
        Optional<Aluno> alunoOpt = alunos.stream().filter(n -> n.getNome().equalsIgnoreCase(nome)).findFirst();
        if(alunoOpt.isPresent()) return alunoOpt.get();
        return null;
    }

}
