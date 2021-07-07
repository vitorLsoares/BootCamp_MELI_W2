package br.com.meli.restaurante.api.model;

import java.time.LocalDate;
import java.util.List;

public class Pedido {

    private String id;
    private Mesa mesa;
    private List<Prato> pratos;
    private double valorTotal;
    private LocalDate data;
    private boolean status;

    public Pedido(String id, Mesa mesa, List<Prato> pratos, double valorTotal, boolean status) {
        this.id = id;
        this.mesa = mesa;
        this.pratos = pratos;
        this.valorTotal = valorTotal;
        this.status = status;
        this.data = LocalDate.now();
    }

    public Pedido(){

    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public void setPrato(Prato prato){ this.pratos.add(prato); }
}
