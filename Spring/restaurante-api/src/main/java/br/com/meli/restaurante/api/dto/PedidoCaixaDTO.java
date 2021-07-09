package br.com.meli.restaurante.api.dto;

import br.com.meli.restaurante.api.model.Mesa;
import br.com.meli.restaurante.api.model.Pedido;
import br.com.meli.restaurante.api.model.Prato;

import java.util.List;
import java.util.UUID;


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
