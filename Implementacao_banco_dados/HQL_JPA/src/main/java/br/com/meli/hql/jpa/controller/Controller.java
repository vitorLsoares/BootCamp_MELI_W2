package br.com.meli.hql.jpa.controller;


import br.com.meli.hql.jpa.entity.Turn;
import br.com.meli.hql.jpa.service.ServiceTurn;
import br.com.meli.hql.jpa.service.ServicerToPopulate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
public class Controller {

    private final ServicerToPopulate service;
    private final ServiceTurn serviceTurn;

    @Autowired
    public Controller(ServicerToPopulate service, ServiceTurn serviceTurn) {
        this.service = service;
        this.serviceTurn = serviceTurn;
    }

    @PostMapping("/populateDb")
    public ResponseEntity<String> populateDB(){
        try {
            service.populateAll();
            return new ResponseEntity<>("Criado",HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Não criado, pelo motivo: "+e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/ex1/{dentista}/{dia}")
    public ResponseEntity<List<Turn>> getPacientPorDentistaNoDia(@PathVariable String dentista, @PathVariable String dia){
        try {
            List<Turn> turnList = serviceTurn.getPacientPorDentistaNoDia(dentista,LocalDate.parse(dia));
            return new ResponseEntity<>(turnList,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/ex2/{dia}")
    public ResponseEntity<Map<String, Integer>> getAgendaDoDia(@PathVariable String dia){
        try {
                Map<String, Integer> Dict = serviceTurn.getAllDentistTurnInDay(LocalDate.parse(dia));
            return new ResponseEntity<>(Dict,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

}
