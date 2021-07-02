package br.com.meli.diploma.controller;

import br.com.meli.diploma.dao.AlunosDAO;
import br.com.meli.diploma.model.Aluno;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
public class Diploma {

    private AlunosDAO dao = new AlunosDAO();

    @GetMapping("/diploma/{nome}")
    public String obterDiploma(@PathVariable String nome){
        Aluno aluno2 = dao.get(nome);
        return dao.calculoDiploma(aluno2);

    }

    @PostMapping
    public ResponseEntity<Aluno> cadastrarAluno(@RequestBody String aluno , UriComponentsBuilder uriBuilder){
        Aluno newAluno = new Aluno(aluno);
        dao.adicionarAluno(newAluno);
        URI uri = uriBuilder.path("/{nome}").buildAndExpand(newAluno.getNome()).toUri();
        return ResponseEntity.created(uri).build();

    }

    @PostMapping("/{nome}/{diciplina}/{nota}")
    public ResponseEntity<Aluno> cadastrarNota(@PathVariable String nome, @PathVariable String diciplina, @PathVariable double nota , UriComponentsBuilder uriBuilder){
        Aluno aluno1 = dao.get(nome);
        if (dao.adicionarNota(aluno1,diciplina,nota)){
            URI uri = uriBuilder.path("/{nome}").buildAndExpand(aluno1.getNome()).toUri();
            return ResponseEntity.created(uri).build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{nome}")
    public Aluno obterAluno(@PathVariable String nome){
        Aluno aluno = dao.get(nome);
        return aluno;

    }


}
