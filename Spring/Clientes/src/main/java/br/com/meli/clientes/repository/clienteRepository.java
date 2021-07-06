package br.com.meli.clientes.repository;

import br.com.meli.clientes.model.Cliente;
import br.com.meli.clientes.model.Pedido;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class clienteRepository {
    private static List<Pedido> pedidos = new ArrayList<>();

    private static List<Cliente> clientes = new ArrayList<>(
            Arrays.asList(
                    new Cliente(0, "Golias", "123.123.123-01", "asd@gmail.com", "4563-7869",pedidos),
                    new Cliente(1, "David", "456.456.456-01", "drt@gmail.com", "6583-7869",pedidos),
                    new Cliente(2, "Sergio", "789.789.789-01", "bgy@gmail.com", "7659-7869",pedidos)
            )
    );

    public List<Cliente> getClientes(){
        return this.clientes;
    }

    public Cliente getClientes(String cpf){
        Optional<Cliente> clienteOptional= this.clientes.stream().filter(i -> i.getCpf().equals(cpf) ).findFirst();
        return clienteOptional.orElse(null);
    }

    public Cliente getClientes(long id){
        Optional<Cliente> clienteOptional= this.clientes.stream().filter(i -> i.getId() == id ).findFirst();
        return clienteOptional.orElse(null);
    }


    public List<Cliente> updatePedido(long idCliente, Pedido pedido){

        List<Pedido> pedidosLocal = new ArrayList<>();
        pedidosLocal = this.clientes.stream().filter(id -> id.getId() == idCliente).findFirst().orElseThrow().getPedidos();
        pedidosLocal.add(pedido);

        for(Cliente cliente : this.clientes){
            if(cliente.getId() == idCliente){
                cliente.setPedidos(pedidosLocal);
            }
        }

        return this.clientes;
    }




}
