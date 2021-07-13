package br.com.meli.link.tracker.repository;

import br.com.meli.link.tracker.model.LinkModel;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkRepository {

    private static final File FILE = new File("linkTracker.json");

    private final ObjectMapper mapper;

    @Autowired
    public LinkRepository(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public List<LinkModel> getList(){
        List<LinkModel> links = new ArrayList<>();
        try {
            FileInputStream is = new FileInputStream(FILE);
            TypeReference<List<LinkModel>> typeReference = new TypeReference<List<LinkModel>>() {};
            links = mapper.readValue(is, typeReference);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return links;
    }

    public void add(LinkModel link) {
        try {
            List<LinkModel> links = getList();
            links.add(link);
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE)));
            mapper.writeValue(out, links);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update(LinkModel link){
        try {
            List<LinkModel> links = getList();
            LinkModel linkOld = links.stream().filter(link1 -> link1.getUrl().equals(link.getUrl())).findFirst().orElse(null);
            if(linkOld != null)
                links.set(links.indexOf(linkOld),link);
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE)));
            mapper.writeValue(out, links);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void remove(LinkModel link){
        try {
            List<LinkModel> links = getList();
            LinkModel linkOld = links.stream().filter(link1 -> link1.getUrl().equals(link.getUrl())).findFirst().orElse(null);
            if(linkOld != null)
                links.remove(link);
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE)));
            mapper.writeValue(out, links);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
