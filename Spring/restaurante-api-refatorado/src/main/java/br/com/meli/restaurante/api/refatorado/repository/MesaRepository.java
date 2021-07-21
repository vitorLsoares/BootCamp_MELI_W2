package br.com.meli.restaurante.api.refatorado.repository;

import br.com.meli.restaurante.api.refatorado.model.Mesa;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MesaRepository {
    private static final File FILE = new File("Mesa.json");

    private final ObjectMapper mapper;

    @Autowired
    public MesaRepository(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public List<Mesa> getList(){
        List<Mesa> mesas = new ArrayList<>();
        try {
            FileInputStream is = new FileInputStream(FILE);
            TypeReference<List<Mesa>> typeReference = new TypeReference<List<Mesa>>() {};
            mesas = mapper.readValue(is, typeReference);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return mesas;
    }

    public void add(Mesa mesa) {
        try {
            List<Mesa> mesas = getList();
            mesas.add(mesa);
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE)));
            mapper.writeValue(out, mesas);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void remove(Mesa prato){
        try {
            List<Mesa> mesas = getList();
            mesas.remove(prato);
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE)));
            mapper.writeValue(out, mesas);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
