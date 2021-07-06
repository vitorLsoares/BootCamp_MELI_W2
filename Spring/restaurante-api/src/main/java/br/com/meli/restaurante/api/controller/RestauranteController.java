package br.com.meli.restaurante.api.controller;

import br.com.meli.restaurante.api.model.Mesa;
import br.com.meli.restaurante.api.model.Pedido;
import br.com.meli.restaurante.api.service.MesaService;
import br.com.meli.restaurante.api.service.PedidoService;
import br.com.meli.restaurante.api.service.PratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
public class RestauranteController {

    @Autowired
    private MesaService mesaService;
    @Autowired
    private PedidoService pedidoService;
    @Autowired
    private PratoService pratoService;

//    @GetMapping("/pedido/{idPedido}")
//    public  ResponseEntity<Pedido> getPedidos(@PathVariable String idPedido){
//        return new ResponseEntity<>(this.pedidoService.getPedido(idPedido), HttpStatus.OK);
//    }

//    @PostMapping("/pedido")
//    public ResponseEntity<Pedido> createProduto(@Validated Pedido pedido){
//        return new ResponseEntity<>(this.pedidoService.createPedido(pedido),HttpStatus.OK);
//    }

    @PostMapping("/pedido")
    public ResponseEntity<Pedido> createProduto(@Validated @RequestBody Mesa mesa, UriComponentsBuilder uriBuilder){

        this.pedidoService.createPedido(mesa);
        URI uri = uriBuilder.path("/pedido/{idMesa}").buildAndExpand(mesa.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/pedido/{idMesa}/{idPrato}/{quantidadePrato}")
    public ResponseEntity<Pedido> addPrato(@Validated @RequestBody int idMesa,@Validated @RequestBody int idPrato ,@Validated @RequestBody int quantidadePrato , UriComponentsBuilder uriBuilder){

        this.pedidoService.addorUpdatePrato(idMesa,idPrato,quantidadePrato);
        URI uri = uriBuilder.path("/pedido/{idMesa}").buildAndExpand(idMesa).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/pedido/{idMesa}")
    public  ResponseEntity<Pedido> getPedidos(@PathVariable int idMesa){
        return new ResponseEntity<>(this.pedidoService.getPedido(idMesa), HttpStatus.OK);
    }


}
