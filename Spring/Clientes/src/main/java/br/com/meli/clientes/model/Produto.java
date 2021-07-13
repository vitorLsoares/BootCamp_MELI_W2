package br.com.meli.clientes.model;

public class Produto {

    private long id;
    private String descricao;
    private String cor;
    private int quatidade;
    private double preco;

    public Produto(long id, String descricao, String cor, int quatidade, double preco) {
        this.id = id;
        this.descricao = descricao;
        this.cor = cor;
        this.quatidade = quatidade;
        this.preco = preco;
    }
    public Produto(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getQuatidade() {
        return quatidade;
    }

    public void setQuatidade(int quatidade) {
        this.quatidade = quatidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
