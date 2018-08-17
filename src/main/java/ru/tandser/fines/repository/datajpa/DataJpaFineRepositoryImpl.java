package ru.tandser.fines.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.tandser.fines.models.CountFine;
import ru.tandser.fines.models.Fine;
import ru.tandser.fines.repository.FineRepository;

import java.util.List;

@Repository
public class DataJpaFineRepositoryImpl implements FineRepository {

    JpaFineRepository      jpaFineRepository;
    JpaCountFineRepository jpaCountFineRepository;

    @Override
    public List<Fine> getByGovNumber(String govNumber) {
        return jpaFineRepository.getByGovNumber(govNumber);
    }

    @Override
    public List<CountFine> getTops() {
        return jpaCountFineRepository.getTops();
    }

    @Override
    public List<CountFine> getTopsByGovNumber(String govNumber) {
        return jpaCountFineRepository.getTopsByGovNumber(govNumber);
    }

    /* Setters and Getters */

    @Autowired
    public void setJpaFineRepository(JpaFineRepository jpaFineRepository) {
        this.jpaFineRepository = jpaFineRepository;
    }

    @Autowired
    public void setJpaCountFineRepository(JpaCountFineRepository jpaCountFineRepository) {
        this.jpaCountFineRepository = jpaCountFineRepository;
    }
}