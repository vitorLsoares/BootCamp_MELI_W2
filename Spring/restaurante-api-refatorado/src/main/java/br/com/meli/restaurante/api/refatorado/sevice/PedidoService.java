package br.com.meli.restaurante.api.refatorado.sevice;

import br.com.meli.restaurante.api.refatorado.model.Mesa;
import br.com.meli.restaurante.api.refatorado.model.Pedido;
import br.com.meli.restaurante.api.refatorado.model.Prato;
import br.com.meli.restaurante.api.refatorado.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PedidoService {

    private PedidoRepository pedidoRepository;
    private MesaService mesaService;

    @Autowired
    public PedidoService(PedidoRepository pedidoRepository, MesaService mesaService) {
        this.pedidoRepository = pedidoRepository;
        this.mesaService = mesaService;
    }

    public Pedido createPedidoByPedido(Pedido pedido) {
        pedidoRepository.add(pedido);
        Optional<Pedido> pedidoOptional = pedidoRepository.getList().stream().filter(pedido1 -> pedido1.equals(pedido)).findFirst();
        return pedidoOptional.map(value -> getPedidoByMesa(value.getMesa().getId())).orElse(null);
    }

    public Pedido createPedidoByMesa(Mesa mesa) {
        if(mesa.getId() > 5)
            throw new RuntimeException("O espaço nao tem mesa mais");

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

        return pedidoRepository.createPedido(mesa);
    }

    public List<Pedido> getPedido() {
        return pedidoRepository.getPedidos();
    }

    public Pedido getPedido(String pedidoId) {
        return pedidoRepository.getPedido(pedidoId);
    }

    public Pedido getPedidoByMesa(int mesaId) {
        return pedidoRepository.getPedido(mesaId);
    }

    public double fechamento(int mesaId){
        pedidoRepository.getPedido(mesaId).setStatus(false);
        double valorFechamento = pedidoRepository.getPedido(mesaId).getValorTotal();
        return valorFechamento;
    }

    public Double caixa(){
        return pedidoRepository.getPedidos().stream().mapToDouble(value -> value.getValorTotal()).sum();
    }

    public Pedido addorUpdatePrato(int mesaId, int idPrato, int quantidade){
        return pedidoRepository.addPrato(mesaId, idPrato, quantidade);
    }

    public Pedido updatePedido(String pedidoId, Pedido prato) {
        return null;
    }

    public void setFechamento(int mesaId) {

    }

}
