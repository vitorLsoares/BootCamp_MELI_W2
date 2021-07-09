package br.com.meli.starwars.api.repository;

import br.com.meli.starwars.api.model.StarWarsCaracter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StarwarRepository {

//    private static List<String> starWarsPersonagem = new ArrayList<String>(
//            Arrays.asList(
//                    "Darth Vader",
//                    "Luke Skywalker",
//                    "Darth Sidious",
//                    "Rey Skywalker",
//                    "Leia Organa",
//                    "Kylo Ren",
//                    "Han Solo",
//                    "R2D2"
//            )
//    );


    private static final File FILE = new File("starwars.json");

    private final ObjectMapper mapper;

    @Autowired
    public StarwarRepository(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public List<StarWarsCaracter> getList(){
        List<StarWarsCaracter> caracters = new ArrayList<>();
        try {
            FileInputStream is = new FileInputStream(FILE);
            TypeReference<List<StarWarsCaracter>> typeReference = new TypeReference<List<StarWarsCaracter>>() {};
            caracters = mapper.readValue(is, typeReference);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return caracters;
    }

    public void add(StarWarsCaracter follower) {
        try {
            List<StarWarsCaracter> caracters = getList();
            caracters.add(follower);
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE)));
            mapper.writeValue(out, caracters);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getStarWarsPersonagem(String chave) {

        List<String> personagensFiltrado = new ArrayList<>();
        List<StarWarsCaracter> personagens = getList();

        for(StarWarsCaracter personagem: personagens){
            for (String s : personagem.getName().split(" ")) {
                if(s.equalsIgnoreCase(chave)) personagensFiltrado.add(personagem.getName());
            }
        }

        return personagensFiltrado;
    }
}
