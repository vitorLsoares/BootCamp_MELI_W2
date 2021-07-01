package br.com.meli.rest.api.Service;

import br.com.meli.rest.api.Model.Produto;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service //
public class ProdutoServiceImpl implements ProdutoService{

    Map<String , Produto> produtos;

    @Override
    public Collection<Produto> getProduto(){
        return produtos.values();
    }

    @Override
    public Produto getProduto(String produtoId) {
        return produtos.get(produtoId);
    }

    @Override
    public Produto updateProduto(String produtoId, Produto produto) {
        Produto produtoFromDB = produtos.get(produtoId);
        produtoFromDB.setName(produto.getName());
        produtoFromDB.setPreco(produto.getPreco());
        return produtoFromDB;
    }

    @Override
    public void deleteProduto(String produtoId) {
        produtos.remove(produtoId);
    }

    @Override
    public Produto createProduto(Produto produto) {

        Produto creatorProduct = new Produto();
        creatorProduct.setName(produto.getName());
        creatorProduct.setPreco(produto.getPreco());
        String productId = UUID.randomUUID().toString();
        creatorProduct.setId(productId);

        if(produtos == null){
            produtos = new HashMap<>();
        }

        produtos.put(productId,creatorProduct);
        return creatorProduct;
    }
}
