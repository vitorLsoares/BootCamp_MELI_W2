package br.com.meli.clientes.model;

import java.math.BigDecimal;
import java.util.List;

public class Pedido {

    private long id;
    private List<Produto> produtos;
    private BigDecimal valorTotal;

    public Pedido(long id, List<Produto> produtos, BigDecimal valorTotal) {
        this.id = id;
        this.produtos = produtos;
        this.valorTotal = valorTotal;
    }

    public Pedido(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
}
