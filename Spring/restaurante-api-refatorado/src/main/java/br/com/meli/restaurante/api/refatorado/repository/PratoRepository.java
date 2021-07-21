package br.com.meli.restaurante.api.refatorado.repository;

import br.com.meli.restaurante.api.refatorado.model.Prato;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PratoRepository {

    private static final File FILE = new File("Prato.json");

    private final ObjectMapper mapper;

    @Autowired
    public PratoRepository(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public List<Prato> getList(){
        List<Prato> pratos = new ArrayList<>();
        try {
            FileInputStream is = new FileInputStream(FILE);
            TypeReference<List<Prato>> typeReference = new TypeReference<List<Prato>>() {};
            pratos = mapper.readValue(is, typeReference);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return pratos;
    }

    public void add(Prato prato) {
        try {
            List<Prato> pratos = getList();
            pratos.add(prato);
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE)));
            mapper.writeValue(out, pratos);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void remove(Prato prato){
        try {
            List<Prato> pratos = getList();
            pratos.remove(pratos);
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE)));
            mapper.writeValue(out, pratos);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
