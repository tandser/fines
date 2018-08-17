package ru.tandser.fines.repository.datajpa;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.tandser.fines.TestHelper;
import ru.tandser.fines.models.User;
import ru.tandser.fines.repository.AbstractRepositoryTest;
import ru.tandser.fines.repository.UserRepository;

import static ru.tandser.fines.TestHelper.*;

public class DataJpaUserRepositoryImplTest extends AbstractRepositoryTest {

    private UserRepository userRepository;

    @Test
    public void getByLicenseNumber() {
        User voloshin    = userRepository.getByLicenseNumber(licenseNumberVoloshin);
        User gippius     = userRepository.getByLicenseNumber(licenseNumberGippius);
        User mandelshtam = userRepository.getByLicenseNumber(licenseNumberMandelshtam);
        User pasternak   = userRepository.getByLicenseNumber(licenseNumberPasternak);
        User twardowski  = userRepository.getByLicenseNumber(licenseNumberTwardowski);

        Assert.assertTrue(TestHelper.USER_MATCHER.equals(TestHelper.voloshin,    voloshin));
        Assert.assertTrue(TestHelper.USER_MATCHER.equals(TestHelper.gippius,     gippius));
        Assert.assertTrue(TestHelper.USER_MATCHER.equals(TestHelper.mandelshtam, mandelshtam));
        Assert.assertTrue(TestHelper.USER_MATCHER.equals(TestHelper.pasternak,   pasternak));
        Assert.assertTrue(TestHelper.USER_MATCHER.equals(TestHelper.twardowski,  twardowski));

        Assert.assertNull(userRepository.getByLicenseNumber("test"));

    }

    /* Setters and Getters */

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}