package ru.tandser.fines.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.tandser.fines.TestHelper;
import ru.tandser.fines.models.CountFine;
import ru.tandser.fines.models.Fine;

import java.util.List;

import static ru.tandser.fines.TestHelper.*;

public class FineServiceImplTest extends AbstractServiceTest {

    private FineService fineService;

    @Test
    public void getByLicenseNumberAndGovNumber() {
        List<Fine> finesVoloshin    = fineService.getByLicenseNumberAndGovNumber(licenseNumberVoloshin,    govNumberVoloshin);
        List<Fine> finesGippius     = fineService.getByLicenseNumberAndGovNumber(licenseNumberGippius,     govNumberGippius);
        List<Fine> finesMandelshtam = fineService.getByLicenseNumberAndGovNumber(licenseNumberMandelshtam, govNumberMandelshtam);
        List<Fine> finesPasternak   = fineService.getByLicenseNumberAndGovNumber(licenseNumberPasternak,   govNumberPasternak);
        List<Fine> finesTwardowski  = fineService.getByLicenseNumberAndGovNumber(licenseNumberTwardowski,  govNumberTwardowski);

        Assert.assertTrue(TestHelper.FINE_MATCHER.equals(TestHelper.finesVoloshin,    finesVoloshin));
        Assert.assertTrue(TestHelper.FINE_MATCHER.equals(TestHelper.finesGippius,     finesGippius));
        Assert.assertTrue(TestHelper.FINE_MATCHER.equals(TestHelper.finesMandelshtam, finesMandelshtam));
        Assert.assertTrue(TestHelper.FINE_MATCHER.equals(TestHelper.finesPasternak,   finesPasternak));
        Assert.assertTrue(TestHelper.FINE_MATCHER.equals(TestHelper.finesTwardowski,  finesTwardowski));

        Assert.assertEquals(0, fineService.getByLicenseNumberAndGovNumber("test", "test").size());
    }

    @Test
    public void getTops() {
        List<CountFine> tops = fineService.getTops();

        Assert.assertTrue(TestHelper.COUNT_FINE_MATCHER.equals(tops, TestHelper.tops));
    }

    @Test
    public void getTopsByLicenseNumberAndGovNumber() {
        List<CountFine> topsVoloshin    = fineService.getTopsByLicenseNumberAndGovNumber(licenseNumberVoloshin,    govNumberVoloshin);
        List<CountFine> topsGippius     = fineService.getTopsByLicenseNumberAndGovNumber(licenseNumberGippius,     govNumberGippius);
        List<CountFine> topsMandelshtam = fineService.getTopsByLicenseNumberAndGovNumber(licenseNumberMandelshtam, govNumberMandelshtam);
        List<CountFine> topsPasternak   = fineService.getTopsByLicenseNumberAndGovNumber(licenseNumberPasternak,   govNumberPasternak);
        List<CountFine> topsTwardowski  = fineService.getTopsByLicenseNumberAndGovNumber(licenseNumberTwardowski,  govNumberTwardowski);

        Assert.assertTrue(TestHelper.COUNT_FINE_MATCHER.equals(TestHelper.topsVoloshin,    topsVoloshin));
        Assert.assertTrue(TestHelper.COUNT_FINE_MATCHER.equals(TestHelper.topsGippius,     topsGippius));
        Assert.assertTrue(TestHelper.COUNT_FINE_MATCHER.equals(TestHelper.topsMandelshtam, topsMandelshtam));
        Assert.assertTrue(TestHelper.COUNT_FINE_MATCHER.equals(TestHelper.topsPasternak,   topsPasternak));
        Assert.assertTrue(TestHelper.COUNT_FINE_MATCHER.equals(TestHelper.topsTwardowski,  topsTwardowski));

        Assert.assertEquals(0, fineService.getTopsByLicenseNumberAndGovNumber("test", "test").size());
    }

    /* Setters and Getters */

    @Autowired
    public void setFineService(FineService fineService) {
        this.fineService = fineService;
    }
}