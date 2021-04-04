package ru.job4j.forum.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.data.PostRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class EditControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PostRepository postRepository;
    @Captor
    private ArgumentCaptor<Post> argumentCaptorPost;

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

    @Test
    @WithMockUser
    public void shouldSuccessfulSaveModelPost() throws Exception {
        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.add("name", "Sell car");
        multiValueMap.add("description", "Description car");
        mockMvc.perform(post("/edit/save/{id}", 0)
                .params(multiValueMap))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/index"));
        Mockito.verify(postRepository).save(argumentCaptorPost.capture());
        Assertions.assertEquals(argumentCaptorPost.getValue().getName(), "Sell car");
    }
}
