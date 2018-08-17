package ru.tandser.fines.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.tandser.fines.models.CountFine;

import java.util.List;

@Transactional(readOnly = true)
public interface JpaCountFineRepository extends JpaRepository<CountFine, Integer> {

    @Query("SELECT new ru.tandser.fines.models.CountFine(cf.duty.name, COUNT(cf)) FROM CountFine AS cf GROUP BY cf.duty.name ORDER BY COUNT(cf) DESC")
    List<CountFine> getTops();

    @Query("SELECT new ru.tandser.fines.models.CountFine(cf.duty.name, COUNT(cf)) FROM CountFine AS cf WHERE cf.car.govNumber = ?1 GROUP BY cf.duty.name ORDER BY COUNT(cf) DESC")
    List<CountFine> getTopsByGovNumber(String govNumber);
}