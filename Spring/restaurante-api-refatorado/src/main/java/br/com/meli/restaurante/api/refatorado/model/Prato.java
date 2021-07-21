package br.com.meli.restaurante.api.refatorado.model;

import java.util.Objects;

public class Prato {
    private int id;
    private double preco;
    private String descricao;
    private int quantidade;

    public Prato(int id, double preco, String descricao, int quantidade) {
        this.id = id;
        this.preco = preco;
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

    public Prato(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prato prato = (Prato) o;
        return id == prato.id && Double.compare(prato.preco, preco) == 0 && quantidade == prato.quantidade && Objects.equals(descricao, prato.descricao);
    }

}
