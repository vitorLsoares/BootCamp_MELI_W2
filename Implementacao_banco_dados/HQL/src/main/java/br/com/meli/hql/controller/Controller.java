package br.com.meli.hql.controller;

import br.com.meli.hql.dto.dtoConsultasPacienteDentista;
import br.com.meli.hql.entity.Turn;
import br.com.meli.hql.service.ServiceAll;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    private final ServiceAll service;

    public Controller(ServiceAll service) {
        this.service = service;
    }

    @PostMapping("/populateDb")
    public ResponseEntity<String> populateDB(){
        String retr = service.populateAll();
        return new ResponseEntity<>(retr, HttpStatus.CREATED);
    }

    @GetMapping("/Ex1/{day}")
    public ResponseEntity<List<dtoConsultasPacienteDentista>> getPacientePorDiaDentista(@PathVariable String day){
        List<dtoConsultasPacienteDentista> retr = service.getPacientePorDiaDentista(day);
        return new ResponseEntity<>(retr, HttpStatus.CREATED);
    }

    @GetMapping("/Ex2/{day}")
    public ResponseEntity<List<Turn>> getDentistNoDia(@PathVariable String day){
        List<Turn> retr = service.getDentistasMais2Turnos(day);
        return new ResponseEntity<>(retr, HttpStatus.CREATED);
    }



}
