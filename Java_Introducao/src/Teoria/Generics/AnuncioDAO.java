package Teoria.Generics;

import Teoria.Anuncios;

import java.util.List;

public class AnuncioDAO implements Armazenavel<Anuncios, Long>{
    @Override
    public void salva(Anuncios anuncios) {

    }

    @Override
    public List<Anuncios> getList() {
        return null;
    }

    @Override
    public Anuncios get(Long id) {
        return null;
    }

}
