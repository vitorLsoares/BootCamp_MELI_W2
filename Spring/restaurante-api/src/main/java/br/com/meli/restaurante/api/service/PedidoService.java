package br.com.meli.restaurante.api.service;

import br.com.meli.restaurante.api.model.Mesa;
import br.com.meli.restaurante.api.model.Pedido;
import br.com.meli.restaurante.api.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PedidoService implements PedidoServiceInter{

    //Aqui é onde estarão as regras de  negócio

    @Autowired
    PedidoRepository pedidoRepository;

    @Override
    public Pedido createPedido(Pedido pedido) {
        return pedidoRepository.createPedido(pedido);
    }

    @Override
    public Pedido createPedido(Mesa mesa) {
        if(mesa.getId() > 5)
            throw new RuntimeException("O espaço nao tem mesa mais");
        return pedidoRepository.createPedido(mesa);
    }

    @Override
    public List<Pedido> getPedido() {
        return pedidoRepository.getPedidos();
    }

    @Override
    public Pedido getPedido(String pedidoId) {
        return pedidoRepository.getPedido(pedidoId);
    }

    @Override
    public Pedido getPedido(int mesaId) {
        return pedidoRepository.getPedido(mesaId);
    }

    @Override
    public Pedido addorUpdatePrato(int mesaId, int idPrato, int quantidade){
        return pedidoRepository.addPrato(mesaId, idPrato, quantidade);
    }


//    @Override
//    public Pedido getPedido(Mesa mesa) {
//        return pedidoRepository.getPedido(mesa);
//    }

    @Override
    public Pedido updatePedido(String pedidoId, Pedido prato) {
        return null;
    }

    @Override
    public void setFechamento(int mesaId) {

    }
}
