package br.com.meli.restaurante.api.repository;


import br.com.meli.restaurante.api.model.Mesa;
import br.com.meli.restaurante.api.model.Pedido;
import br.com.meli.restaurante.api.model.Prato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class PedidoRepository {

    @Autowired
    MesaRepository mesaRepository;
    @Autowired
    PratoRepository pratoRepository;

    private static List<Pedido> pedidos = new ArrayList<>();

    public List<Pedido> getPedidos(){
        return pedidos;
    }

    public Pedido createPedido(Pedido produto) {

        //Criando um Pedido
        Pedido creatorPedido = new Pedido(
                UUID.randomUUID().toString(),
                produto.getMesa(),
                produto.getPratos(),
                0.0,
                true
        );
        this.pedidos.add(creatorPedido);
        return creatorPedido;
    }

    public Pedido createPedido(Mesa mesa) {

        List<Prato> pratosNew = new ArrayList<>();

        mesaRepository.createMesa(mesa);

        //Criando um Pedido
        Pedido creatorPedido = new Pedido(
                UUID.randomUUID().toString(),
                mesaRepository.getMesa(mesa.getId()),
                pratosNew,
                0.0,
                true
        );
        this.pedidos.add(creatorPedido);
        return creatorPedido;
    }

    public Pedido addPrato(int idMesa , int idPrato, int quantidade){
        List<Prato> pratosLocal;
        Optional<Pedido> pedidoOptional = pedidos.stream().filter(m -> m.getMesa().getId() == idMesa ).findFirst();
        pratosLocal = pedidoOptional.orElse(null).getPratos();

        Optional<Prato> pratoOptional = pratosLocal.stream().filter(p -> p.getId() == idPrato ).findFirst();
        if (pratoOptional.isPresent()){
            pratosLocal.stream().filter(p -> p.getId() == idPrato ).findFirst().get().setQuantidade(quantidade);
        }
        else {
            pratosLocal.add(pratoRepository.updatePrato_quantidade(idPrato,quantidade));
        }

        pedidoOptional.get().setPratos(pratosLocal);
        return pedidoOptional.orElse(null);
    }

    public Pedido getPedido(String id){
        Optional<Pedido> pedidoOptional = pedidos.stream().filter(i -> i.getId().equals(id) ).findFirst();
        return pedidoOptional.orElse(null);
    }

    public Pedido getPedido(int mesaId){
        Optional<Pedido> pedidoOptional = pedidos.stream().filter(m -> m.getMesa().getId() == mesaId ).findFirst();
        return pedidoOptional.orElse(null);
    }

//    public Pedido updatePedido(String pedidoId, Pedido pedido ){
//        Optional<Pedido> pedidoOptional = pedidos.stream().filter(i -> i.getId() == pedidoId).findFirst();
//        Pedido produtoFromDB = pedidos.get(pedidoId);
//        produtoFromDB.setMesa(pedido.getMesa());
//        produtoFromDB.setPreco(pedido.getPreco());
//        return produtoFromDB;
//    }


}
