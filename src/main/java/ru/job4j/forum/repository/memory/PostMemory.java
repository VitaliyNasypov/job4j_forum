package ru.job4j.forum.repository.memory;

import org.springframework.stereotype.Repository;
import ru.job4j.forum.model.Comment;
import ru.job4j.forum.model.Post;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class PostMemory {
    private static final AtomicInteger POST_ID = new AtomicInteger();
    private static final Map<Integer, Post> POSTS = new ConcurrentHashMap<>();

    static {
        UserMemory userMemory = new UserMemory();
        Post postFirst = Post.of("First post");
        postFirst.setDesc("Description first post");
        postFirst.setUser(userMemory.findById(1));
        Post postSecond = Post.of("Second post");
        postSecond.setDesc("Description second post");
        postSecond.setUser(userMemory.findById(1));
        PostMemory postMemory = new PostMemory();
        postMemory.create(postFirst);
        postMemory.create(postSecond);
        CommentMemory commentMemory = new CommentMemory();
        Set<Comment> setFirst = new HashSet<>();
        setFirst.add(commentMemory.findById(1));
        postFirst.setComments(setFirst);
        Set<Comment> setSecond = new HashSet<>();
        setSecond.add(commentMemory.findById(2));
        postSecond.setComments(setSecond);
    }

    public List<Post> findAll() {
        System.out.println(POSTS.size());
        return new ArrayList<>(POSTS.values());
    }

    public Post create(Post post) {
        System.out.println(POSTS.size());
        post.setId(POST_ID.incrementAndGet());
        post.setCreated(Calendar.getInstance());
        return POSTS.put(post.getId(), post);
    }

    public Post findById(int id) {
        return POSTS.get(id);
    }
}
