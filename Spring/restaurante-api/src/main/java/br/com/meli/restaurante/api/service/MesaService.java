package br.com.meli.restaurante.api.service;

import br.com.meli.restaurante.api.model.Mesa;
import br.com.meli.restaurante.api.repository.MesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MesaService implements MesaServiceInter{

    @Autowired
    MesaRepository mesaRepository;

    @Override
    public Mesa createMesa(Mesa mesa) {
        return mesaRepository.createMesa(mesa);
    }

    @Override
    public List<Mesa> getMesa() {
        return mesaRepository.getMesas();
    }

    @Override
    public Mesa getMesa(int mesaId) {
        return mesaRepository.getMesa(mesaId);
    }

    @Override
    public Mesa updateMesa(int mesaId, Mesa Mesa) {
        return null;
    }

    @Override
    public void deleteMesa(int mesaId) {

    }
}
