package br.com.meli.link.tracker.dto;

import br.com.meli.link.tracker.model.LinkModel;

public class LinkModelDTO {
    private String url;
    private long counter;

    public LinkModelDTO(String url, long counter) {
        this.url = url;
        this.counter = counter;
    }
    public LinkModelDTO(){

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getCounter() {
        return counter;
    }

    public void setCounter(long counter) {
        this.counter = counter;
    }

    public LinkModel converteToModel(long id,LinkModelDTO link,String password){
        return new LinkModel(id,link.getUrl(),link.getCounter(),password);
    }

    public LinkModelDTO converteToDTO(LinkModel link){
        return new LinkModelDTO(link.getUrl(), link.getCounter());
    }
}
