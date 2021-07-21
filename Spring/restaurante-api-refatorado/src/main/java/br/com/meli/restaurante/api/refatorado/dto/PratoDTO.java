package br.com.meli.restaurante.api.refatorado.dto;

public class PratoDTO {

    private double preco;
    private String descricao;
    private int quantidade;

    public PratoDTO(double preco, String descricao, int quantidade) {
        this.preco = preco;
        this.descricao = descricao;
        this.quantidade = quantidade;
    }
    public PratoDTO(){

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

}
