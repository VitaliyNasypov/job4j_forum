package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.User;
import ru.job4j.forum.repository.data.PostRepository;

import java.util.Calendar;
import java.util.List;

@Service
public class PostService {
    private PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAll() {
        return (List<Post>) postRepository.findAll();
    }

    public Post findById(int id) {
        return postRepository.findById(id).orElse(new Post());
    }

    @Transactional(rollbackFor = Exception.class)
    public void save(int id, String name, String description, User user) {
        Post post = Post.of(name);
        post.setDescription(description);
        post.setUser(user);
        if (id > 0) {
            post.setId(id);
        } else {
            post.setCreated(Calendar.getInstance());
        }
        postRepository.save(post);
    }
}