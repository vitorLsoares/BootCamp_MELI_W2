package br.com.meli.rest.api.Model;

public class Produto {

    private String id;
    private String name;
    private double preco;

//    public Produto(String id, String name, String preco) {
//        this.id = id;
//        this.name = name;
//        this.preco = preco;
//    }
//
//    public Produto(){
//
//    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }


}
