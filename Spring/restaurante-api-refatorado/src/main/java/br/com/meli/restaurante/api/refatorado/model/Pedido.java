package br.com.meli.restaurante.api.refatorado.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Pedido {

    private String id;
    private Mesa mesa;
    private List<Prato> pratos;
    private double valorTotal;
    private LocalDate data;
    private boolean status;

    public Pedido(String id, Mesa mesa, List<Prato> pratos, double valorTotal, LocalDate data, boolean status) {
        this.id = id;
        this.mesa = mesa;
        this.pratos = pratos;
        this.valorTotal = valorTotal;
        this.data = data;
        this.status = status;
    }

    public Pedido(){

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

    public List<Prato> getPratos() {
        return pratos;
    }

    public void setPratos(List<Prato> pratos) {
        this.pratos = pratos;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Double.compare(pedido.valorTotal, valorTotal) == 0 && status == pedido.status && Objects.equals(id, pedido.id) && Objects.equals(mesa, pedido.mesa) && Objects.equals(pratos, pedido.pratos) && Objects.equals(data, pedido.data);
    }

}
