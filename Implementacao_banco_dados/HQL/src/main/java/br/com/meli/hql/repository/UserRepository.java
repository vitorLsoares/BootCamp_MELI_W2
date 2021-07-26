package br.com.meli.hql.repository;

import br.com.meli.hql.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class UserRepository {

    private EntityManager em;

    public UserRepository(EntityManager em) {
        this.em = em;
    }

    public UserRepository() {
    }

    public void cadastra(User user){
        this.em.persist(user);
    }

}
