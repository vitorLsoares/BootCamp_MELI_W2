package br.com.meli.clientes.model;

import java.util.List;

public class Cliente {

    private long id;
    private String nome;
    private String cpf;
    private String email;
    private String telNumber;
    private List<Pedido> pedidos;

    public Cliente(long id, String nome, String cpf, String email, String telNumber, List<Pedido> pedidos) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telNumber = telNumber;
        this.pedidos = pedidos;
    }
    public Cliente(){

    }

    public long getId() {
        return id;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void addPedido(Pedido pedido){

        this.pedidos.add(pedido);
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
