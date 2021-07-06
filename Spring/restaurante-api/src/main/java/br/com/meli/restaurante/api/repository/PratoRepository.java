package br.com.meli.restaurante.api.repository;

import br.com.meli.restaurante.api.model.Prato;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class PratoRepository {

    private static List<Prato> pratos = new ArrayList<>(
            Arrays.asList(
                    new Prato(0,55.0,"Rodizio Simples", 0),
                    new Prato(1,65.0,"Rodizio Médio",0),
                    new Prato( 2, 85.0,"Rodizio Premium", 0),
                    new Prato(3,45.0,"yakisoba Prato unico",0),
                    new Prato(4, 39.99,"Lámen prato unico",0)
            )
    );

    public List<Prato> getPratos(){
        return this.pratos;
    }

    public Prato createPrato(Prato prato) {

        //Criando um Pedido
        Prato creatorPrato = new Prato(
                prato.getId(),
                prato.getPreco(),
                prato.getDescricao(),
                prato.getQuantidade()
        );
        this.pratos.add(creatorPrato);
        return creatorPrato;
    }

    public Prato getPrato(int id){
        Optional<Prato> pedidoOptional = pratos.stream().filter(i -> i.getId() == id).findFirst();
        return pedidoOptional.orElse(null);
    }

    public Prato updatePrato_quantidade(int pratoId , int quantidade){

        this.pratos.stream()
                .filter(i -> i.getId() == pratoId)
                .findFirst()
                .get()
                .setQuantidade(quantidade);

        return  this.pratos.stream().filter(i -> i.getId() == pratoId).findFirst().get();
    }


}
