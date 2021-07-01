package br.com.meli.rest.api.Controller;


import br.com.meli.rest.api.Model.Produto;
import br.com.meli.rest.api.Service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("produto")
public class REST_CRUD {

    @Autowired
    private ProdutoService produtoService;

    //List<Produto> produtos = new ArrayList<Produto>();
//    @GetMapping
//    public String getUsers() {
//        return "inside getUser method";
//    }



    @GetMapping
    public ResponseEntity<Collection<Produto>> getProdutos() {
        return new ResponseEntity<>(this.produtoService.getProduto(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Produto> createProduto(@Validated @RequestBody Produto produto){
            return new ResponseEntity<>(this.produtoService.createProduto(produto),HttpStatus.OK);
    }

    @GetMapping(path="/{userId}")
    public ResponseEntity<Produto> getProduto(@PathVariable String produtoId){
        return new ResponseEntity<>(this.produtoService.getProduto(produtoId),HttpStatus.OK);
    }

    @PutMapping(path="/{userId}")
    public ResponseEntity<Produto> updateProduto(@PathVariable String produtoId, @Validated @RequestBody Produto produto) {

        return new ResponseEntity<>(this.produtoService.updateProduto(produtoId, produto), HttpStatus.OK);
    }

    @DeleteMapping(path="/{userId}")
    public ResponseEntity<Produto> deleteProduto(@PathVariable String produtoId) {
        this.produtoService.deleteProduto(produtoId);
        return ResponseEntity.noContent().build();
    }





}
