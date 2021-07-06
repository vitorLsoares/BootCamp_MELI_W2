package br.com.meli.clientes.repository;

import br.com.meli.clientes.model.Produto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class produtoRepository {

    private static List<Produto> produtos = new ArrayList<>(
            Arrays.asList(
                    new Produto(0,"Iphone","Rose",35,1000.6),
                    new Produto(1,"Lava Louça","Branca",7,2050.6),
                    new Produto(2,"Caneta","Azul",2000,12.17),
                    new Produto(3,"Garrafinha","Verde",4,100.99)
            )
    );


}
