package Teoria.Generics;

import java.util.List;

public class VendedorDAO implements Armazenavel<Vendedor,String>{
    @Override
    public void salva(Vendedor vendedor) {

    }

    @Override
    public List<Vendedor> getList() {
        return null;
    }

    @Override
    public Vendedor get(String id) {
        return null;
    }
}
