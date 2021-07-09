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
        pedidos.add(creatorPedido);
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
        pedidos.add(creatorPedido);
        return creatorPedido;
    }

    public Pedido addPrato(int idMesa , int idPrato, int quantidade){

        Pedido pedidoLocal;
        Optional<Pedido> pedidoOptional = pedidos.stream().filter(m -> m.getMesa().getId() == idMesa ).findFirst();
        pedidoLocal = pedidoOptional.orElse(null);

        if ( pedidoLocal.getPratos().stream().anyMatch(id -> id.getId() == idPrato) ){
            pedidoLocal.getPratos().stream().filter(id -> id.getId() == idPrato).findFirst().get().setQuantidade(quantidade);
        }
        else{
            Prato pratoEscolhido = pratoRepository.getPrato(idPrato);
            if (pratoEscolhido != null){
                pratoEscolhido.setQuantidade(quantidade);
                pedidoLocal.setPrato(pratoEscolhido);
            }
        }

        pedidoLocal.setValorTotal(calcValorTotal(pedidoLocal.getPratos()));

        return pedidoLocal;
    }

    public Pedido getPedido(String id){
        Optional<Pedido> pedidoOptional = pedidos.stream().filter(i -> i.getId().equals(id) ).findFirst();
        return pedidoOptional.orElse(null);
    }

    public Pedido getPedido(int mesaId){
        Optional<Pedido> pedidoOptional = pedidos.stream().filter(m -> m.getMesa().getId() == mesaId ).findFirst();
        return pedidoOptional.orElse(null);
    }

    public static double calcValorTotal(List<Prato> pratos){
        return pratos.stream().mapToDouble(prato -> prato.getQuantidade() * prato.getPreco()).sum();
    }

    public void deleteMesa(int mesaId){
        Optional<Pedido> pedidoOptional = pedidos.stream().filter(m -> m.getMesa().getId() == mesaId ).findFirst();
        pedidos.remove(pedidoOptional.orElse(null));
    }
}
