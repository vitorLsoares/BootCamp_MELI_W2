package br.com.meli.restaurante.api.service;

import br.com.meli.restaurante.api.model.Prato;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PratoService implements PratoServiceInter{
    @Override
    public Prato createPrato(Prato prato) {
        return null;
    }

    @Override
    public List<Prato> getPratos() {
        return null;
    }

    @Override
    public Prato getPrato(String pratoId) {
        return null;
    }

    @Override
    public Prato updatePrato(String pratoId, Prato prato) {
        return null;
    }

    @Override
    public void deletePrato(String pratoId) {

    }
}
