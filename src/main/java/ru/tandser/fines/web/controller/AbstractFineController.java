package ru.tandser.fines.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import ru.tandser.fines.dto.FlatFine;
import ru.tandser.fines.models.CountFine;
import ru.tandser.fines.service.FineService;

import java.util.List;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.StringUtils.isAnyBlank;
import static org.apache.commons.lang3.StringUtils.trim;

public abstract class AbstractFineController {

    private static final int LIMIT_TOP = 5;

    private FineService fineService;

    public List<FlatFine> getByLicenseNumberAndGovNumber(String licenseNumber, String govNumber) {
        return fineService.getByLicenseNumberAndGovNumber(trim(licenseNumber), trim(govNumber))
                .stream()
                .map(FlatFine::valueOf)
                .collect(Collectors.toList());
    }

    public List<CountFine> getTops(String licenseNumber, String govNumber) {
        List<CountFine> fines = isAnyBlank(licenseNumber, govNumber)
                ? fineService.getTops()
                : fineService.getTopsByLicenseNumberAndGovNumber(trim(licenseNumber), trim(govNumber));

        return fines.stream().limit(LIMIT_TOP).collect(Collectors.toList());
    }

    /* Setters and Getters */

    @Autowired
    public void setFineService(FineService fineService) {
        this.fineService = fineService;
    }
}