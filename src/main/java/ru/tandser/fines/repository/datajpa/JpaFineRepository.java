package ru.tandser.fines.repository.datajpa;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.tandser.fines.models.Fine;

import java.util.List;

@Transactional(readOnly = true)
public interface JpaFineRepository extends JpaRepository<Fine, Integer> {

    @EntityGraph(Fine.WITH_CAR_AND_DUTY)
    @Query("SELECT f FROM Fine AS f WHERE f.car.govNumber = ?1")
    List<Fine> getByGovNumber(String govNumber);
}