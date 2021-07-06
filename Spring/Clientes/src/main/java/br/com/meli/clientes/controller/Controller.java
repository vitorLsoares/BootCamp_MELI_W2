package br.com.meli.clientes.controller;

import br.com.meli.clientes.model.Cliente;
import br.com.meli.clientes.model.Pedido;
import br.com.meli.clientes.service.clienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
public class Controller {


    @Autowired
    clienteService clientService;


    @GetMapping("/pedidos/{cpf}")
    public ResponseEntity<Cliente> getClienteByCPF(@PathVariable String cpf){
        Cliente cliente = clientService.getCliente(cpf);
        return new ResponseEntity<Cliente>(cliente,HttpStatus.OK);
    }

    @PutMapping("/{id}/pedidos")
    public ResponseEntity<List<Cliente>> updatePedidosById(@PathVariable long id, @Validated @RequestBody Pedido pedido, UriComponentsBuilder uriBuilder){
        List<Cliente> client = clientService.updatePedido(id, pedido);
        URI uri = uriBuilder.path("/pedidos/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/pedidosID/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable long id){
        Cliente cliente = clientService.getCliente(id);
        return new ResponseEntity<Cliente>(cliente,HttpStatus.OK);
    }

}
