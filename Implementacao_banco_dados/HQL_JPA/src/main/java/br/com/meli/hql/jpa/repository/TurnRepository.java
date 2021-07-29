package br.com.meli.hql.jpa.repository;

import br.com.meli.hql.jpa.entity.Turn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TurnRepository extends JpaRepository<Turn,Long> {
    List<Turn> findByDiary_DentistNameAndDayEquals(String diary_dentist_name, LocalDate day);
    Integer countAllByDayAndDiary_Dentist_Name(LocalDate day, String diary_dentist_name);
}
