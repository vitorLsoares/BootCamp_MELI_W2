package br.com.meli.restaurante.api.controller;

import br.com.meli.restaurante.api.model.Mesa;
import br.com.meli.restaurante.api.service.MesaService;
import br.com.meli.restaurante.api.model.Pedido;
import br.com.meli.restaurante.api.service.PedidoService;
import br.com.meli.restaurante.api.service.PratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.BufferedReader;
import java.io.Reader;
import java.net.URI;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class RestauranteController {

    @Autowired
    private MesaService mesaService;
    @Autowired
    private PedidoService pedidoService;
    @Autowired
    private PratoService pratoService;

    @PostMapping("/pedido")
    public ResponseEntity<Pedido> createProduto(@Validated @RequestBody Mesa mesa, UriComponentsBuilder uriBuilder){

        this.pedidoService.createPedido(mesa);
        URI uri = uriBuilder.path("/pedido/{idMesa}").buildAndExpand(mesa.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/pedido/{idMesa}/{idPrato}/{quantidadePrato}")
    public ResponseEntity<Pedido> addPrato(@Validated @PathVariable int idMesa,@Validated @PathVariable int idPrato ,@Validated @PathVariable int quantidadePrato , UriComponentsBuilder uriBuilder){

        this.pedidoService.addorUpdatePrato(idMesa,idPrato,quantidadePrato);
        URI uri = uriBuilder.path("/pedido/{idMesa}").buildAndExpand(idMesa).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/pedido/{idMesa}")
    public  ResponseEntity<Pedido> getPedidos(@PathVariable int idMesa){
        return new ResponseEntity<>(this.pedidoService.getPedido(idMesa), HttpStatus.OK);
    }

    @GetMapping("/pedido/list")
    public ResponseEntity<List<Pedido>> getPedidosList(){
        return new ResponseEntity<>(this.pedidoService.getPedido(), HttpStatus.OK);
    }

    @DeleteMapping("/pedido/fechamento/{idMesa}")
    public ResponseEntity<String> deleteFechamento(@PathVariable int idMesa) {
        return new ResponseEntity<>("Pedido da mesa" + idMesa + " fechou com R$ " + this.pedidoService.fechamento(idMesa), HttpStatus.OK);
    }

    @GetMapping("/pedido/caixa")
    public ResponseEntity<String> getCaixa(){
        return new ResponseEntity<String>("O fechando do dia "+ LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " foi de R$"+pedidoService.caixa(), HttpStatus.OK);
    }

}
