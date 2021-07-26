package br.com.meli.hql.jpa.repository;

import br.com.meli.hql.jpa.entity.Turn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnRepository extends JpaRepository<Turn,Long> {
}
