package br.com.meli.clientes.model;

import java.math.BigDecimal;

public class Produto {

    private long id;
    private String descricao;
    private String cor;
    private int quatidade;
    private double preço;

    public Produto(long id, String descricao, String cor, int quatidade, double preço) {
        this.id = id;
        this.descricao = descricao;
        this.cor = cor;
        this.quatidade = quatidade;
        this.preço = preço;
    }
    public Produto(){

    }
}
