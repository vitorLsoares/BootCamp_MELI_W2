package br.com.meli.restaurante.api.refatorado.repository;

import br.com.meli.restaurante.api.refatorado.model.Pedido;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PedidoRepository {
    private static final File FILE = new File("Pedido.json");

    private final ObjectMapper mapper;

    @Autowired
    public PedidoRepository(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public List<Pedido> getList(){
        List<Pedido> pedidos = new ArrayList<>();
        try {
            FileInputStream is = new FileInputStream(FILE);
            TypeReference<List<Pedido>> typeReference = new TypeReference<List<Pedido>>() {};
            pedidos = mapper.readValue(is, typeReference);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return pedidos;
    }

    public void add(Pedido pedido) {
        try {
            List<Pedido> pedidos = getList();
            pedidos.add(pedido);
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE)));
            mapper.writeValue(out, pedidos);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void remove(Pedido pedido){
        try {
            List<Pedido> pedidos = getList();
            pedidos.remove(pedido);
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE)));
            mapper.writeValue(out, pedidos);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
