package br.com.meli.restaurante.api.repository;

import br.com.meli.restaurante.api.model.Mesa;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MesaRepository {

    private static List<Mesa> mesas = new ArrayList<Mesa>();

    public Mesa getMesa(int i){
        Optional<Mesa> mesaOptional = mesas.stream().filter(ID -> ID.getId() == i).findFirst();
        return mesaOptional.orElse(null);
    }

    public List<Mesa> getMesas(){
        return mesas;
    }

    public Mesa createMesa(Mesa mesa) {

        //Criando um Pedido
        Mesa creatorMesa = new Mesa(
                mesa.getId(),
                mesa.getGarcom()
        );
        this.mesas.add(creatorMesa);
        return creatorMesa;
    }
}
