package br.com.meli.restaurante.api.service;

import br.com.meli.restaurante.api.model.Mesa;
import br.com.meli.restaurante.api.model.Pedido;

import java.util.List;

public interface PedidoServiceInter {

    Pedido createPedido(Pedido pedido);
    Pedido createPedido(Mesa mesa);
    List<Pedido> getPedido();
    Pedido getPedido(String pedidoId);
    Pedido getPedido(int idMesa);
    Pedido updatePedido(String pedidoId, Pedido prato);
    Pedido addorUpdatePrato(int mesaId, int idPrato, int quantidade);
    void deletePedido(String pedidoId);

}
