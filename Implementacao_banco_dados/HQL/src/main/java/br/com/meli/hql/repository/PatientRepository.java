package br.com.meli.hql.repository;

import br.com.meli.hql.entity.Patient;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;

@Repository
public class PatientRepository {
    private EntityManager em;

    public PatientRepository(EntityManager em) {
        this.em = em;
    }

    public PatientRepository() {
    }

    public void cadastra(Patient patient){
        this.em.persist(patient);
    }
}
