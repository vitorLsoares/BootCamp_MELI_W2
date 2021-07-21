package br.com.meli.restaurante.api.refatorado.sevice;

import br.com.meli.restaurante.api.refatorado.model.Mesa;
import br.com.meli.restaurante.api.refatorado.repository.MesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MesaService {

    @Autowired
    MesaRepository mesaRepository;

    public Mesa createMesa(Mesa mesa){

        //Criando um Pedido
        Mesa creatorMesa = new Mesa(
                mesa.getId(),
                mesa.getGarcom()
        );
        mesaRepository.add(creatorMesa);
        return creatorMesa;

    }
}
