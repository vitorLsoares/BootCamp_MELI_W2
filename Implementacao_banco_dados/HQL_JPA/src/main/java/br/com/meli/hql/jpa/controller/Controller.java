package br.com.meli.hql.jpa.controller;


import br.com.meli.hql.jpa.service.ServicerToPopulate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final ServicerToPopulate service;

    @Autowired
    public Controller(ServicerToPopulate service) {
        this.service = service;
    }

    @PostMapping("/populateDb")
    public ResponseEntity<String> populateDB(){
        String retr = service.populateAll();
        return new ResponseEntity<>(retr, HttpStatus.CREATED);
    }

}
