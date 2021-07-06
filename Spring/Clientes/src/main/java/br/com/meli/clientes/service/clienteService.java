package br.com.meli.clientes.service;

import br.com.meli.clientes.model.Cliente;
import br.com.meli.clientes.model.Pedido;
import br.com.meli.clientes.repository.clienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class clienteService {

    @Autowired
    clienteRepository clientRepository;

    public Cliente getCliente(String cpf){
        return clientRepository.getClientes(cpf);
    }
    public Cliente getCliente(long id){
        return clientRepository.getClientes(id);
    }

    public List<Cliente> getClientes(){
        return clientRepository.getClientes();
    }

    public List<Cliente> updatePedido(long idCliente, Pedido pedido){
        return clientRepository.updatePedido(idCliente,pedido);
    }

}
