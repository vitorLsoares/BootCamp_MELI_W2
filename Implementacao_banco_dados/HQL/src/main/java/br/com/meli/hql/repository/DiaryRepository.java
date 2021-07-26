package br.com.meli.hql.repository;

import br.com.meli.hql.entity.Diary;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class DiaryRepository {

    private EntityManager em;

    public DiaryRepository(EntityManager em) {
        this.em = em;
    }

    public DiaryRepository() {
    }

    public void cadastra(Diary diary){
        this.em.persist(diary);
    }
}
