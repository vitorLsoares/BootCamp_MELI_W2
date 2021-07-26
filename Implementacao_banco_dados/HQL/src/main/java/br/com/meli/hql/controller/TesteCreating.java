package br.com.meli.hql.controller;

import br.com.meli.hql.entity.User;
import br.com.meli.hql.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.*;
import java.util.Map;

public class TesteCreating {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("dentinho");
        EntityManager em = factory.createEntityManager();


        User usuario = new User("jonas","4ef6","admin");


        try {
            em.getTransaction().begin();
            UserRepository userRepository = new UserRepository(em);
            userRepository.cadastra(usuario);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
        }

    }
}
