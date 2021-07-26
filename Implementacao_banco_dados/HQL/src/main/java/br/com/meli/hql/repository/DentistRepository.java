package br.com.meli.hql.repository;

import br.com.meli.hql.entity.Dentist;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class DentistRepository {

    private EntityManager em;

    public DentistRepository(EntityManager em) {
        this.em = em;
    }

    public DentistRepository() {
    }

    public void cadastra(Dentist dentist){
        this.em.persist(dentist);
    }


}
