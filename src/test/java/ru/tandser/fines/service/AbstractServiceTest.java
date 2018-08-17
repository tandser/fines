package ru.tandser.fines.service;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.tandser.fines.TestHelper;

@ActiveProfiles("local")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/repository.xml", "classpath:spring/service.xml"})
public abstract class AbstractServiceTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @BeforeClass
    public static void beforeClass() throws Exception {
        TestHelper.loadMocks();
    }
}