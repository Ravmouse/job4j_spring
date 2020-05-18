package ru.job4j.h5boot.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.h5boot.entity.Acc;
import ru.job4j.h5boot.service.BootService;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * @author Vitaly Vasilyev, date: 18.05.2020, e-mail: rav.energ@rambler.ru
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@WebMvcTest(AddController.class)
public class AddControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private BootService service;

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"}, password = "ad")
    public void whenGetAddPageThenPageIsLoaded() throws Exception {
        mvc.perform(get("/accidents/add")
                .accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(view().name("add"));
    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"}, password = "ad")
    public void whenAddAccidentToAddPageThenAccidentIsAdded() throws Exception {
        mvc.perform(post("/accidents/add")
                .param("name", "1").param("text", "2").param("address", "3"))
                .andExpect(status().is3xxRedirection());
        verify(service, times(1)).add(ArgumentMatchers.refEq(new Acc("1", "2", "3")));
    }
}