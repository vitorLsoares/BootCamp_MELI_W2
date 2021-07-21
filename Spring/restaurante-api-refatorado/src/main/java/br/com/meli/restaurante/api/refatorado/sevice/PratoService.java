package br.com.meli.restaurante.api.refatorado.sevice;

import br.com.meli.restaurante.api.refatorado.repository.PratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PratoService {

    @Autowired
    PratoRepository pratoRepository;
}
