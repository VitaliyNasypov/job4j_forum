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
import ru.job4j.forum.model.Comment;
import ru.job4j.forum.repository.data.CommentRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CommentRepository commentRepository;
    @Captor
    private ArgumentCaptor<Comment> argumentCaptorComment;

    @Test
    @WithMockUser
    public void shouldRedirectToPostPage() throws Exception {
        this.mockMvc.perform(get("/post/{id}", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("post"))
                .andExpect(model().attributeExists("user"))
                .andExpect(view().name("post"));
    }

    @Test
    @WithMockUser
    public void shouldSuccessfulSaveComment() throws Exception {
        mockMvc.perform(post("/post/add/{id}", 1)
                .param("comment", "New Test Comment"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrlTemplate("/post/{id}", 1));
        Mockito.verify(commentRepository).save(argumentCaptorComment.capture());
        Assertions.assertEquals(argumentCaptorComment.getValue().getText(), "New Test Comment");
    }
}
