package ru.tandser.fines.web.rest.ajax;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.web.servlet.ResultActions;
import ru.tandser.fines.TestHelper;
import ru.tandser.fines.dto.FlatFine;
import ru.tandser.fines.models.CountFine;
import ru.tandser.fines.web.AbstractControllerTest;
import ru.tandser.fines.web.json.JsonConverter;

import java.util.List;

import static ru.tandser.fines.TestHelper.*;

public class FineAjaxControllerTest extends AbstractControllerTest {

    @Test
    public void getByLicenseNumberAndGovNumber() throws Exception {
        ResultActions finesVoloshinRes    = post(licenseNumberVoloshin,    govNumberVoloshin,    "");
        ResultActions finesGippiusRes     = post(licenseNumberGippius,     govNumberGippius,     "");
        ResultActions finesMandelshtamRes = post(licenseNumberMandelshtam, govNumberMandelshtam, "");
        ResultActions finesPasternakRes   = post(licenseNumberPasternak,   govNumberPasternak,   "");
        ResultActions finesTwardowskiRes  = post(licenseNumberTwardowski,  govNumberTwardowski,  "");

        List<FlatFine> finesVoloshin    = JsonConverter.fromJsonToList(asString(finesVoloshinRes),    FlatFine.class);
        List<FlatFine> finesGippius     = JsonConverter.fromJsonToList(asString(finesGippiusRes),     FlatFine.class);
        List<FlatFine> finesMandelshtam = JsonConverter.fromJsonToList(asString(finesMandelshtamRes), FlatFine.class);
        List<FlatFine> finesPasternak   = JsonConverter.fromJsonToList(asString(finesPasternakRes),   FlatFine.class);
        List<FlatFine> finesTwardowski  = JsonConverter.fromJsonToList(asString(finesTwardowskiRes),  FlatFine.class);

        Assert.assertTrue(FLAT_FINE_MATCHER.equals(flatFinesVoloshin,    finesVoloshin));
        Assert.assertTrue(FLAT_FINE_MATCHER.equals(flatFinesGippius,     finesGippius));
        Assert.assertTrue(FLAT_FINE_MATCHER.equals(flatFinesMandelshtam, finesMandelshtam));
        Assert.assertTrue(FLAT_FINE_MATCHER.equals(flatFinesPasternak,   finesPasternak));
        Assert.assertTrue(FLAT_FINE_MATCHER.equals(flatFinesTwardowski,  finesTwardowski));
    }

    @Test
    public void getTops() throws Exception {
        ResultActions topsRes = post("", "", TOPS);

        List<CountFine> tops = JsonConverter.fromJsonToList(asString(topsRes), CountFine.class);

        Assert.assertTrue(COUNT_FINE_MATCHER.equals(tops, TestHelper.tops));

        ResultActions topsVoloshinRes    = post(licenseNumberVoloshin,    govNumberVoloshin,    TOPS);
        ResultActions topsGippiusRes     = post(licenseNumberGippius,     govNumberGippius,     TOPS);
        ResultActions topsMandelshtamRes = post(licenseNumberMandelshtam, govNumberMandelshtam, TOPS);
        ResultActions topsPasternakRes   = post(licenseNumberPasternak,   govNumberPasternak,   TOPS);
        ResultActions topsTwardowskiRes  = post(licenseNumberTwardowski,  govNumberTwardowski,  TOPS);

        List<CountFine> topsVoloshin    = JsonConverter.fromJsonToList(asString(topsVoloshinRes),    CountFine.class);
        List<CountFine> topsGippius     = JsonConverter.fromJsonToList(asString(topsGippiusRes),     CountFine.class);
        List<CountFine> topsMandelshtam = JsonConverter.fromJsonToList(asString(topsMandelshtamRes), CountFine.class);
        List<CountFine> topsPasternak   = JsonConverter.fromJsonToList(asString(topsPasternakRes),   CountFine.class);
        List<CountFine> topsTwardowski  = JsonConverter.fromJsonToList(asString(topsTwardowskiRes),  CountFine.class);

        Assert.assertTrue(COUNT_FINE_MATCHER.equals(TestHelper.topsVoloshin,    topsVoloshin));
        Assert.assertTrue(COUNT_FINE_MATCHER.equals(TestHelper.topsGippius,     topsGippius));
        Assert.assertTrue(COUNT_FINE_MATCHER.equals(TestHelper.topsMandelshtam, topsMandelshtam));
        Assert.assertTrue(COUNT_FINE_MATCHER.equals(TestHelper.topsPasternak,   topsPasternak));
        Assert.assertTrue(COUNT_FINE_MATCHER.equals(TestHelper.topsTwardowski,  topsTwardowski));
    }
}