package br.com.meli.restaurante.api.refatorado.model;

import java.lang.reflect.Method;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mesa mesa = (Mesa) o;
        return id == mesa.id && Objects.equals(garcom, mesa.garcom);
    }

}
