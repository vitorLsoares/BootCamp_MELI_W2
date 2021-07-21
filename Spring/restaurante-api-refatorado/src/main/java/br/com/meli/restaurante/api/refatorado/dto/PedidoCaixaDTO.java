package br.com.meli.restaurante.api.refatorado.dto;

import br.com.meli.restaurante.api.refatorado.model.Mesa;


public class PedidoCaixaDTO {

    private Mesa mesa;
    private double valorTotal;

    public PedidoCaixaDTO(Mesa mesa, double valorTotal) {
        this.mesa = mesa;
        this.valorTotal = valorTotal;
    }
    public PedidoCaixaDTO(){

    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
