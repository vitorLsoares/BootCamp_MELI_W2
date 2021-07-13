package br.com.meli.link.tracker.service;

import br.com.meli.link.tracker.exception.InvestigarRedirectExpection;
import br.com.meli.link.tracker.model.LinkModel;
import br.com.meli.link.tracker.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.net.*;
import java.security.SecureRandom;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LinkService {

    @Autowired
    LinkRepository linkRepository;

    public List<LinkModel> getList(){
        return linkRepository.getList();
    }

    public LinkModel getLinkById(long id){
        return linkRepository.getList().stream().filter(link -> link.getId() == id).findFirst().orElse(null);
    }

    public long createLinkDB(String url){
        LinkModel linkCreator = new LinkModel(getList().size()+1,url,0,generateRandomPassword(5));
        addLink(linkCreator);
        return linkCreator.getId();
    }

    public void addLink(LinkModel linkModel){
        isValid(linkModel.getUrl());
        linkRepository.add(linkModel);
    }

    public static void isValid(String url){
        try {
            new URL(url).toURI();
        }catch (MalformedURLException | URISyntaxException e) {
            // the URL is not in a valid form
            throw new InvestigarRedirectExpection("Investigar Redirect - " + e.getMessage());
        }
    }

    public String getOpenConection(long id) throws IOException {
        LinkModel link = getLinkById(id);
        long counter = link.getCounter()+1;
        link.setCounter(counter);
        linkRepository.update(link);
        HttpURLConnection connection = (HttpURLConnection) new URL(link.getUrl()).openConnection();
        connection.getResponseCode();
        return connection.getURL().toString();
    }

    public LinkModel remove(long id){
        LinkModel linkRemover = getLinkById(id);
        linkRepository.remove(linkRemover);
        return getLinkById(id);
    }

    public long getMetrics(long id){
        return getLinkById(id).getCounter();
    }

    public static String generateRandomPassword(int len)
    {
        SecureRandom random = new SecureRandom();
        return random.ints(len, 97, 122 + 1)
                .mapToObj(i -> String.valueOf((char)i))
                .collect(Collectors.joining());
    }
}

