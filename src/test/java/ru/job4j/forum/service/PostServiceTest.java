package ru.job4j.forum.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.data.PostRepository;

import java.util.Collections;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyInt;

@ExtendWith(MockitoExtension.class)
public class PostServiceTest {
    @Mock
    private PostRepository postRepository;

    @Test
    public void shouldCalledMethodFindAll() {
        Mockito.when(postRepository.findAll()).thenReturn(Collections.emptyList());
        new PostService(postRepository).getAll();
        Mockito.verify(postRepository).findAll();
    }

    @Test
    public void shouldReturnPost() {
        Mockito.when(postRepository.findById(anyInt())).thenReturn(Optional.of(Post.of("Test")));
        Post post = new PostService(postRepository).findById(1);
        Assertions.assertEquals("Test", post.getName());
    }
}
