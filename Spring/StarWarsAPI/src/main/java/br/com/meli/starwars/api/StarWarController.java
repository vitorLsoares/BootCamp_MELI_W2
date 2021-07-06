package br.com.meli.starwars.api;

import br.com.meli.starwars.api.repository.StarwarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StarWarController {

    @Autowired
    StarwarRepository starwarRepository;

    @GetMapping("/pesonagem/{nome}")
    public ResponseEntity<List<String>> getPersonagemByNome(@PathVariable String nome){
        List<String> personagensFiltrados = starwarRepository.getStarWarsPersonagem(nome);
        return new ResponseEntity<List<String>>(personagensFiltrados, HttpStatus.OK);
    }

}
