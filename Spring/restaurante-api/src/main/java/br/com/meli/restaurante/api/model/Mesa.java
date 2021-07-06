package br.com.meli.restaurante.api.model;

public class Mesa {

    private int id;
    private String garcom;

    public Mesa(int id, String garcom) {
        this.id = id;
        this.garcom = garcom;
    }
    public Mesa(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGarcom() {
        return garcom;
    }

    public void setGarcom(String garcom) {
        this.garcom = garcom;
    }
}
