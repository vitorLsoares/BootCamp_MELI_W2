package br.com.meli.hql.repository;

import br.com.meli.hql.entity.TurnStatus;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class TurnStatusRepositry {
    private EntityManager em;

    public TurnStatusRepositry(EntityManager em) {
        this.em = em;
    }

    public TurnStatusRepositry() {
    }

    public void cadastra(TurnStatus turnStatus){
        this.em.persist(turnStatus);
    }
}
