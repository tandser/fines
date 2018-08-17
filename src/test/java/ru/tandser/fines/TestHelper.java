package ru.tandser.fines;

import org.springframework.util.ResourceUtils;
import ru.tandser.fines.dto.FlatFine;
import ru.tandser.fines.models.*;
import ru.tandser.fines.web.json.JsonConverter;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class TestHelper {

    public static final Matcher<User>      USER_MATCHER       = createUserMatcher();
    public static final Matcher<Car>       CAR_MATCHER        = createCarMatcher();
    public static final Matcher<Duty>      DUTY_MATCHER       = createDutyMatcher();
    public static final Matcher<CountFine> COUNT_FINE_MATCHER = createCountMatcher();
    public static final Matcher<Fine>      FINE_MATCHER       = createFineMatcher();
    public static final Matcher<FlatFine>  FLAT_FINE_MATCHER  = createFlatFineMatcher();

    public static final String licenseNumberVoloshin    = "GA5763FWA";
    public static final String licenseNumberGippius     = "MH7731BYW";
    public static final String licenseNumberMandelshtam = "LN5214YKQ";
    public static final String licenseNumberPasternak   = "MA4012QIB";
    public static final String licenseNumberTwardowski  = "BM8531WBM";

    public static final String govNumberVoloshin     = "А564ФУ 70";
    public static final String govNumberGippius      = "М283ЕУ 70";
    public static final String govNumberMandelshtam  = "Е884ИТ 70";
    public static final String govNumberPasternak    = "К121ЮА 70";
    public static final String govNumberTwardowski   = "Ш433СО 70";

    public static User voloshin;
    public static User gippius;
    public static User mandelshtam;
    public static User pasternak;
    public static User twardowski;

    public static List<Fine> finesVoloshin;
    public static List<Fine> finesGippius;
    public static List<Fine> finesMandelshtam;
    public static List<Fine> finesPasternak;
    public static List<Fine> finesTwardowski;

    public static List<CountFine> tops;

    public static List<CountFine> topsVoloshin;
    public static List<CountFine> topsGippius;
    public static List<CountFine> topsMandelshtam;
    public static List<CountFine> topsPasternak;
    public static List<CountFine> topsTwardowski;

    public static List<FlatFine> flatFinesVoloshin;
    public static List<FlatFine> flatFinesGippius;
    public static List<FlatFine> flatFinesMandelshtam;
    public static List<FlatFine> flatFinesPasternak;
    public static List<FlatFine> flatFinesTwardowski;

    public static Matcher<User> createUserMatcher() {
        return new Matcher<>(User.class, (expected, actual) ->
                expected == actual || (Objects.equals(expected.getName(),          actual.getName())       &&
                                       Objects.equals(expected.getPatronymic(),    actual.getPatronymic()) &&
                                       Objects.equals(expected.getSurname(),       actual.getSurname())    &&
                                       Objects.equals(expected.getLicenseNumber(), actual.getLicenseNumber())));
    }

    public static Matcher<Car> createCarMatcher() {
        return new Matcher<>(Car.class, (expected, actual) ->
                expected == actual || (Objects.equals(expected.getBrand(),     actual.getBrand()) &&
                                       Objects.equals(expected.getModel(),     actual.getModel()) &&
                                       Objects.equals(expected.getGovNumber(), actual.getGovNumber())));
    }

    public static Matcher<Duty> createDutyMatcher() {
        return new Matcher<>(Duty.class, (expected, actual) ->
                expected == actual || (Objects.equals(expected.getName(),  actual.getName()) &&
                                       Objects.equals(expected.getPrice(), actual.getPrice())));
    }

    public static Matcher<CountFine> createCountMatcher() {
        return new Matcher<>(CountFine.class, (expected, actual) ->
                expected == actual || (Objects.equals(expected.getDutyName(), actual.getDutyName()) &&
                                       Objects.equals(expected.getCount(),    actual.getCount())));
    }

    public static Matcher<Fine> createFineMatcher() {
        return new Matcher<>(Fine.class, (expected, actual) -> {
            if (expected == actual) {
                return true;
            }

            if (expected.getCar() != null && actual.getCar() != null) {
                if (!CAR_MATCHER.equals(expected.getCar(), actual.getCar())) {
                    return false;
                }

                if (expected.getCar().getUser() != null && actual.getCar().getUser() != null) {
                    if (!USER_MATCHER.equals(expected.getCar().getUser(), actual.getCar().getUser())) {
                        return false;
                    }
                }
            }

            if (expected.getDuty() != null && actual.getDuty() != null) {
                if (!DUTY_MATCHER.equals(expected.getDuty(), actual.getDuty())) {
                    return false;
                }
            }

            return Objects.equals(expected.getStatus(), actual.getStatus());
        });
    }

    public static Matcher<FlatFine> createFlatFineMatcher() {
        return new Matcher<>(FlatFine.class, (expected, actual) ->
                expected == actual || Objects.equals(expected.getUserName(),          actual.getUserName())          &&
                                      Objects.equals(expected.getUserPatronymic(),    actual.getUserPatronymic())    &&
                                      Objects.equals(expected.getUserSurname(),       actual.getUserSurname())       &&
                                      Objects.equals(expected.getUserLicenseNumber(), actual.getUserLicenseNumber()) &&
                                      Objects.equals(expected.getCarBrand(),          actual.getCarBrand())          &&
                                      Objects.equals(expected.getCarModel(),          actual.getCarModel())          &&
                                      Objects.equals(expected.getCarGovNumber(),      actual.getCarGovNumber())      &&
                                      Objects.equals(expected.getDutyName(),          actual.getDutyName())          &&
                                      Objects.equals(expected.getDutyPrice(),         actual.getDutyPrice())         &&
                                      Objects.equals(expected.getFineStatus(),        actual.getFineStatus()));
    }

    public static void loadMocks() throws Exception {
        Iterator<User> mocks = JsonConverter.fromJsonToList(ResourceUtils.getFile("classpath:mocks/users.json"), User.class).iterator();

        voloshin    = mocks.next();
        gippius     = mocks.next();
        mandelshtam = mocks.next();
        pasternak   = mocks.next();
        twardowski  = mocks.next();

        finesVoloshin    = JsonConverter.fromJsonToList(ResourceUtils.getFile("classpath:mocks/fines/voloshin.json"),    Fine.class);
        finesGippius     = JsonConverter.fromJsonToList(ResourceUtils.getFile("classpath:mocks/fines/gippius.json"),     Fine.class);
        finesMandelshtam = JsonConverter.fromJsonToList(ResourceUtils.getFile("classpath:mocks/fines/mandelshtam.json"), Fine.class);
        finesPasternak   = JsonConverter.fromJsonToList(ResourceUtils.getFile("classpath:mocks/fines/pasternak.json"),   Fine.class);
        finesTwardowski  = JsonConverter.fromJsonToList(ResourceUtils.getFile("classpath:mocks/fines/twardowski.json"),  Fine.class);

        tops = JsonConverter.fromJsonToList(ResourceUtils.getFile("classpath:mocks/tops.json"), CountFine.class);

        topsVoloshin    = JsonConverter.fromJsonToList(ResourceUtils.getFile("classpath:mocks/tops/voloshin.json"),    CountFine.class);
        topsGippius     = JsonConverter.fromJsonToList(ResourceUtils.getFile("classpath:mocks/tops/gippius.json"),     CountFine.class);
        topsMandelshtam = JsonConverter.fromJsonToList(ResourceUtils.getFile("classpath:mocks/tops/mandelshtam.json"), CountFine.class);
        topsPasternak   = JsonConverter.fromJsonToList(ResourceUtils.getFile("classpath:mocks/tops/pasternak.json"),   CountFine.class);
        topsTwardowski  = JsonConverter.fromJsonToList(ResourceUtils.getFile("classpath:mocks/tops/twardowski.json"),  CountFine.class);

        flatFinesVoloshin    = JsonConverter.fromJsonToList(ResourceUtils.getFile("classpath:mocks/fines/flat/voloshin.json"),    FlatFine.class);
        flatFinesGippius     = JsonConverter.fromJsonToList(ResourceUtils.getFile("classpath:mocks/fines/flat/gippius.json"),     FlatFine.class);
        flatFinesMandelshtam = JsonConverter.fromJsonToList(ResourceUtils.getFile("classpath:mocks/fines/flat/mandelshtam.json"), FlatFine.class);
        flatFinesPasternak   = JsonConverter.fromJsonToList(ResourceUtils.getFile("classpath:mocks/fines/flat/pasternak.json"),   FlatFine.class);
        flatFinesTwardowski  = JsonConverter.fromJsonToList(ResourceUtils.getFile("classpath:mocks/fines/flat/twardowski.json"),  FlatFine.class);
    }
}