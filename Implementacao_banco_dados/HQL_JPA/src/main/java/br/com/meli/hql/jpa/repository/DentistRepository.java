package br.com.meli.hql.jpa.repository;

import br.com.meli.hql.jpa.entity.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DentistRepository extends JpaRepository<Dentist,Long> {

    @Override
    List<Dentist> findAll();
}
