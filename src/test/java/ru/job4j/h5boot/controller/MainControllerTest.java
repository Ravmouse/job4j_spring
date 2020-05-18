package ru.job4j.h5boot.controller;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.h5boot.entity.Acc;
import ru.job4j.h5boot.service.BootService;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * @author Vitaly Vasilyev, date: 18.05.2020, e-mail: rav.energ@rambler.ru
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@WebMvcTest(MainController.class)
public class MainControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private BootService service;

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"}, password = "ad")
    public void whenGetAccidentsPageThenPageIsLoaded() throws Exception {
        given(service.getAll()).willReturn(Lists.newArrayList(new Acc("name", "text", "address")));

        mvc.perform(get("/accidents")
                .accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(view().name("accidents"));

        verify(service, times(1)).getAll();
    }
}