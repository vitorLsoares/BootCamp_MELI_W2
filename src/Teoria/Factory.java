package Teoria;

import java.util.Locale;

public abstract class Factory {

    public static Pessoa getInstance(String clazz, String nome){ //Estado compartilhado com todas as classes
        if(clazz.toLowerCase().equals("a]uno")){
            return new Aluno(nome);
        }
        if(clazz.toLowerCase().equals("professor")){
            return new Professor(nome);
        }
        throw new RuntimeException("Especifique o tipo de instancia");
    }

    public static Pessoa getInstance(TipoPessoa tipo, String nome){
        if(tipo.equals(TipoPessoa.ALUNO)){
            return new Aluno(nome);
        }
        if(tipo.equals(TipoPessoa.Professor)){
            return new Professor(nome);
        }
        throw new RuntimeException("Especifique o tipo de instancia");
    }

//    public static Pessoa getInstance(TipoPessoa tipo, String nome, String sexo){
//        if(tipo.equals(TipoPessoa.ALUNO)){
//            return new Aluno(nome);
//        }
//        if(tipo.equals(TipoPessoa.Professor)){
//            return new Professor(nome);
//        }
//        throw new RuntimeException("Especifique o tipo de instancia");
//    }


}
