package ru.tandser.fines.web.rest.ajax;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.tandser.fines.dto.FlatFine;
import ru.tandser.fines.models.CountFine;
import ru.tandser.fines.web.controller.AbstractFineController;

import java.util.List;

@RestController
@RequestMapping(FineAjaxController.AJAX_PATH)
public class FineAjaxController extends AbstractFineController {

    private static final Logger logger = LoggerFactory.getLogger(FineAjaxController.class);

    public static final String AJAX_PATH = "/ajax/fines";

    @Override
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FlatFine> getByLicenseNumberAndGovNumber(@RequestParam String licenseNumber, @RequestParam String govNumber) {
        logger.debug("getByLicenseNumberAndGovNumber: licenseNumber = {}, govNumber = {}", licenseNumber, govNumber);
        return super.getByLicenseNumberAndGovNumber(licenseNumber, govNumber);
    }

    @Override
    @PostMapping(path = "tops", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CountFine> getTops(String licenseNumber, String govNumber) {
        logger.debug("getTops: licenseNumber = {}, govNumber = {}", licenseNumber, govNumber);
        return super.getTops(licenseNumber, govNumber);
    }
}