package br.com.meli.restaurante.api.dto;

import br.com.meli.restaurante.api.model.Mesa;
import br.com.meli.restaurante.api.model.Pedido;
import br.com.meli.restaurante.api.model.Prato;

import java.util.List;
import java.util.UUID;


public class PedidoDTO {

    private Mesa mesa;
    private double valorTotal;
    private List<Prato> pratos;
    private boolean status;

    public PedidoDTO(Mesa mesa, double valorTotal, List<Prato> pratos) {
        this.mesa = mesa;
        this.valorTotal = valorTotal;
        this.pratos = pratos;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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

    public List<Prato> getPratos() {
        return pratos;
    }

    public void setPratos(List<Prato> pratos) {
        this.pratos = pratos;
    }

    public static PedidoDTO conversorPedidos_DTO(Pedido pedido){
        return new PedidoDTO(pedido.getMesa(), pedido.getValorTotal(),pedido.getPratos());
    }

    public static Pedido conversorDTO_Pedidos (PedidoDTO pedido){
        return new Pedido(UUID.randomUUID().toString(), pedido.getMesa(), pedido.getPratos(),pedido.getValorTotal(), pedido.isStatus());
    }


}
