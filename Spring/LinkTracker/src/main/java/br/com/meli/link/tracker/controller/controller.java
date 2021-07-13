package br.com.meli.link.tracker.controller;

import br.com.meli.link.tracker.exception.ConectionException;
import br.com.meli.link.tracker.model.LinkModel;
import br.com.meli.link.tracker.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.util.UriComponentsBuilder;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class controller {

    @Autowired
    LinkService linkService;

    @PostMapping("/link")
    public ResponseEntity<String> createURI(@RequestParam String url,UriComponentsBuilder uriBuilder){
        long id = linkService.createLinkDB(url);
        URI uri = uriBuilder.path("/link/{linkId}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/link/{linkId}")
    public RedirectView getLink(@PathVariable long linkId,@RequestParam String password) throws IOException, URISyntaxException {
        if(linkService.getLinkById(linkId).getPassword().equals(password))
        {
            String link = linkService.getOpenConection(linkId);
            return new RedirectView(link);
        }
        throw new ConectionException("Senha Errada");
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<String> getMetrics(@PathVariable long linkId){
        return new ResponseEntity<>("Esse link foi acessado "+linkService.getMetrics(linkId)+" vezes",HttpStatus.OK);
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<LinkModel> removeURI(@PathVariable long linkId){
        return new ResponseEntity<>(linkService.remove(linkId),HttpStatus.NOT_FOUND);
    }




}
