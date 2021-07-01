package br.com.meli.rest.api.Service;

import br.com.meli.rest.api.Model.Produto;

import java.util.Collection;

public interface ProdutoService {

    Produto createProduto(Produto produto);
    Collection<Produto> getProduto();
    Produto getProduto(String produtoId);
    Produto updateProduto(String produtoId, Produto produto);
    void deleteProduto(String produtoId);

}
