package br.com.meli.restaurante.api.service;

import br.com.meli.restaurante.api.model.Prato;

import java.util.List;

public interface PratoServiceInter {

    Prato createPrato(Prato prato);
    List<Prato> getPratos();
    Prato getPrato(String pratoId);
    Prato updatePrato(String pratoId, Prato prato);
    void deletePrato(String pratoId);

}
