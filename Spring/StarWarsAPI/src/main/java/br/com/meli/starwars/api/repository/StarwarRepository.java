package br.com.meli.starwars.api.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StarwarRepository {

    private static List<String> starWarsPersonagem = new ArrayList<String>(
            Arrays.asList(
                    "Darth Vader",
                    "Luke Skywalker",
                    "Darth Sidious",
                    "Rey Skywalker",
                    "Leia Organa",
                    "Kylo Ren",
                    "Han Solo",
                    "R2D2"
            )
    );


    public List<String> getStarWarsPersonagem(String chave) {

        List<String> personagensFiltrado = new ArrayList<>();
        for(String personagem: starWarsPersonagem){
            for (String s : personagem.split(" ")) {
                if(s.equalsIgnoreCase(chave)) personagensFiltrado.add(personagem);
            }
        }

        return personagensFiltrado;
    }
}
