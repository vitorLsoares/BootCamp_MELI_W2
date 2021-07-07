package br.com.meli.link.tracker.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
public class controller {

    @PostMapping("/link")
    public ResponseEntity<?> createURI(UriComponentsBuilder uriBuilder){
        URI uri = uriBuilder.path("/link/{linkId}").buildAndExpand().toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/link/{linkId}")
    public ResponseEntity<String> getLink(){
        return null;
    }

}
