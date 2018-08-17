package ru.tandser.fines.web;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import ru.tandser.fines.TestHelper;

import javax.annotation.PostConstruct;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.tandser.fines.web.rest.ajax.FineAjaxController.AJAX_PATH;

@ActiveProfiles("local")
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/repository.xml", "classpath:spring/service.xml", "classpath:spring/web.xml"})
public abstract class AbstractControllerTest {

    private static final CharacterEncodingFilter CHARACTER_ENCODING_FILTER = new CharacterEncodingFilter();

    public static final String TOPS = "/tops";

    private   WebApplicationContext webApplicationContext;
    protected MockMvc               mockMvc;

    @BeforeClass
    public static void beforeClass() throws Exception {
        CHARACTER_ENCODING_FILTER.setEncoding("UTF-8");
        CHARACTER_ENCODING_FILTER.setForceEncoding(true);

        TestHelper.loadMocks();
    }

    @PostConstruct
    private void postConstruct() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                                 .addFilter(CHARACTER_ENCODING_FILTER)
                                 .build();
    }

    protected ResultActions post(String licenseNumber, String govNumber, String path) throws Exception {
        return mockMvc.perform(MockMvcRequestBuilders.post(AJAX_PATH + path).param("licenseNumber", licenseNumber).param("govNumber", govNumber))
                      .andExpect(status().isOk())
                      .andExpect(content().contentType(APPLICATION_JSON_UTF8));
    }

    protected String asString(ResultActions resultActions) throws Exception {
        return resultActions.andReturn().getResponse().getContentAsString();
    }

    /* Setters and Getters */

    @Autowired
    public void setWebApplicationContext(WebApplicationContext webApplicationContext) {
        this.webApplicationContext = webApplicationContext;
    }
}