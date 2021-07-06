package br.com.meli.restaurante.api.service;

import br.com.meli.restaurante.api.model.Mesa;

import java.util.List;

public interface MesaServiceInter {

    Mesa createMesa(Mesa mesa);
    List<Mesa> getMesa();
    Mesa getMesa(int mesaId);
    Mesa updateMesa(int mesaId, Mesa Mesa);
    void deleteMesa(int mesaId);

}
