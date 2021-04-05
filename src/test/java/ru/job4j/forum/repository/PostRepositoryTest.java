package ru.job4j.forum.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.data.PostRepository;

@DataJpaTest
public class PostRepositoryTest {
    @Autowired
    private PostRepository postRepository;

    @Test
    public void shouldUpdatePost() {
        Post post = postRepository.findById(1).orElse(new Post());
        Assertions.assertEquals("First Description", post.getDescription());
        post.setDescription("New_Description_Test");
        postRepository.update(post.getId(), post.getName(), post.getDescription());
        Post postUpdate = postRepository.findById(1).orElse(new Post());
        Assertions.assertEquals("New_Description_Test", postUpdate.getDescription());
    }
}
