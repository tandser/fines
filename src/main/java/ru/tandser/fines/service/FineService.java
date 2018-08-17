package ru.tandser.fines.service;

import ru.tandser.fines.models.CountFine;
import ru.tandser.fines.models.Fine;

import java.util.List;

public interface FineService {

    List<Fine> getByLicenseNumberAndGovNumber(String licenseNumber, String govNumber);

    List<CountFine> getTops();

    List<CountFine> getTopsByLicenseNumberAndGovNumber(String licenseNumber, String govNumber);
}