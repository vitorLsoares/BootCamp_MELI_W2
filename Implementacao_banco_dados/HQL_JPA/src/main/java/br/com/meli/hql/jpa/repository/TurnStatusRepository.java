package br.com.meli.hql.jpa.repository;

import br.com.meli.hql.jpa.entity.TurnStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnStatusRepository extends JpaRepository<TurnStatus,Long> {
}
