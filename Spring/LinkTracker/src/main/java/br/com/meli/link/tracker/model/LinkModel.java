package br.com.meli.link.tracker.model;


import java.util.Objects;

public class LinkModel {

    private long id;
    private String url;
    private long counter;
    private String password;

    public LinkModel(long id, String url, long counter, String password) {
        this.id = id;
        this.url = url;
        this.counter = counter;
        this.password = password;
    }

    public LinkModel(){

    }

    public long getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public long getCounter() {
        return counter;
    }

    public void setCounter(long counter) {
        this.counter = counter;
    }


    public String getPassword() {
        return password;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkModel linkModel = (LinkModel) o;
        return id == linkModel.id && counter == linkModel.counter && Objects.equals(url, linkModel.url) && Objects.equals(password, linkModel.password);
    }

}
