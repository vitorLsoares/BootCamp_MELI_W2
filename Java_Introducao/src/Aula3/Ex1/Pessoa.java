package Aula3.Ex1;

import java.util.Locale;

public class Pessoa implements Precedete<Pessoa>{
    private String nome;
    private String cpf;

    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public Pessoa() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public int precedeA(Pessoa pessoa) {
        int retorna = -1;
        //if (this.nome.compareToIgnoreCase(pessoa.getNome()) > 0){
            if (this.cpf.compareToIgnoreCase(pessoa.getCpf()) > 0){
                retorna =  this.cpf.compareToIgnoreCase(pessoa.getCpf());
            }
        //}

        return retorna;
    }

}
