package ru.job4j.forum.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class EditControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser
    public void shouldRedirectToEditPage() throws Exception {
        mockMvc.perform(get("/edit/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(view().name("edit"))
                .andExpect(model().attributeExists("post"))
                .andExpect(model().attributeExists("user"));
    }

    @Test
    @WithMockUser
    public void shouldRedirectToEditPageWithEmptyPostAttribute() throws Exception {
        mockMvc.perform(get("/edit/{id}", 0))
                .andExpect(status().isOk())
                .andExpect(view().name("edit"))
                .andExpect(model().attributeDoesNotExist("post"))
                .andExpect(model().attributeExists("user"));
    }
}
