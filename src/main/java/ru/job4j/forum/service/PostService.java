package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.memory.PostMemory;

import java.util.List;

@Service
public class PostService {
    private PostMemory postMemory;

    public PostService(PostMemory postMemory) {
        this.postMemory = postMemory;
    }

    public List<Post> getAll() {
        return postMemory.findAll();
    }
}