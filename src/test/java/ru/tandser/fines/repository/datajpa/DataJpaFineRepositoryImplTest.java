package ru.tandser.fines.repository.datajpa;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.tandser.fines.TestHelper;
import ru.tandser.fines.models.CountFine;
import ru.tandser.fines.models.Fine;
import ru.tandser.fines.repository.AbstractRepositoryTest;
import ru.tandser.fines.repository.FineRepository;

import java.util.List;

import static ru.tandser.fines.TestHelper.*;

public class DataJpaFineRepositoryImplTest extends AbstractRepositoryTest {

    private FineRepository fineRepository;

    @Test
    public void getByGovNumber() {
        List<Fine> finesVoloshin    = fineRepository.getByGovNumber(govNumberVoloshin);
        List<Fine> finesGippius     = fineRepository.getByGovNumber(govNumberGippius);
        List<Fine> finesMandelshtam = fineRepository.getByGovNumber(govNumberMandelshtam);
        List<Fine> finesPasternak   = fineRepository.getByGovNumber(govNumberPasternak);
        List<Fine> finesTwardowski  = fineRepository.getByGovNumber(govNumberTwardowski);

        Assert.assertTrue(TestHelper.FINE_MATCHER.equals(TestHelper.finesVoloshin,    finesVoloshin));
        Assert.assertTrue(TestHelper.FINE_MATCHER.equals(TestHelper.finesGippius,     finesGippius));
        Assert.assertTrue(TestHelper.FINE_MATCHER.equals(TestHelper.finesMandelshtam, finesMandelshtam));
        Assert.assertTrue(TestHelper.FINE_MATCHER.equals(TestHelper.finesPasternak,   finesPasternak));
        Assert.assertTrue(TestHelper.FINE_MATCHER.equals(TestHelper.finesTwardowski,  finesTwardowski));

        Assert.assertEquals(0, fineRepository.getByGovNumber("test").size());
    }

    @Test
    public void getTops() {
        List<CountFine> tops = fineRepository.getTops();

        Assert.assertTrue(TestHelper.COUNT_FINE_MATCHER.equals(tops, TestHelper.tops));
    }

    @Test
    public void getTopsByGovNumber() {
        List<CountFine> topsVoloshin    = fineRepository.getTopsByGovNumber(govNumberVoloshin);
        List<CountFine> topsGippius     = fineRepository.getTopsByGovNumber(govNumberGippius);
        List<CountFine> topsMandelshtam = fineRepository.getTopsByGovNumber(govNumberMandelshtam);
        List<CountFine> topsPasternak   = fineRepository.getTopsByGovNumber(govNumberPasternak);
        List<CountFine> topsTwardowski  = fineRepository.getTopsByGovNumber(govNumberTwardowski);

        Assert.assertTrue(TestHelper.COUNT_FINE_MATCHER.equals(TestHelper.topsVoloshin,    topsVoloshin));
        Assert.assertTrue(TestHelper.COUNT_FINE_MATCHER.equals(TestHelper.topsGippius,     topsGippius));
        Assert.assertTrue(TestHelper.COUNT_FINE_MATCHER.equals(TestHelper.topsMandelshtam, topsMandelshtam));
        Assert.assertTrue(TestHelper.COUNT_FINE_MATCHER.equals(TestHelper.topsPasternak,   topsPasternak));
        Assert.assertTrue(TestHelper.COUNT_FINE_MATCHER.equals(TestHelper.topsTwardowski,  topsTwardowski));

        Assert.assertEquals(0, fineRepository.getTopsByGovNumber("test").size());
    }

    /* Setters and Getters */

    @Autowired
    public void setFineRepository(FineRepository fineRepository) {
        this.fineRepository = fineRepository;
    }
}