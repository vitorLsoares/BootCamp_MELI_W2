package br.com.meli.hql.repository;

import br.com.meli.hql.entity.Turn;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

@Repository
public class TurnRepository {

    private EntityManager em;
    public TurnRepository(EntityManager em) {
        this.em = em;
    }

    public TurnRepository() {
    }

    public void cadastra(Turn turn){
        this.em.persist(turn);
    }

    public List<Turn> findByDay(String day)
    {
        TypedQuery<Turn> qry = this.em.createQuery("select t from Turn as t where t.day =: dayParm", Turn.class);
        qry.setParameter("dayParm", LocalDate.parse(day));
        return qry.getResultList();
    }

    public List<Turn> findDenistInDay(String day)
    {
        TypedQuery<Turn> qry = this.em.createQuery("select d1.name, count(d1.name) as n_dentist from Turn as t\n" +
                "inner join Diary as d ON(d.id = t.diary.id)" +
                "inner join Dentist as d1 on(d.dentist.id = d1.id)" +
                "where t.day =: dayParm group by d1.name", Turn.class);
        qry.setParameter("dayParm", LocalDate.parse(day));
        return qry.getResultList();
    }
}
