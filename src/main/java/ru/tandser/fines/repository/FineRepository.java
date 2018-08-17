package ru.tandser.fines.repository;

import ru.tandser.fines.models.CountFine;
import ru.tandser.fines.models.Fine;

import java.util.List;

public interface FineRepository {

    List<Fine> getByGovNumber(String govNumber);

    List<CountFine> getTops();

    List<CountFine> getTopsByGovNumber(String govNumber);
}