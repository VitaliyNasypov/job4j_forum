package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.job4j.forum.model.Comment;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.User;
import ru.job4j.forum.repository.data.CommentRepository;

import java.util.Calendar;

@Service
public class CommentService {
    private CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Transactional(rollbackFor = Exception.class)
    public void save(int id, String comment, User user) {
        Post post = new Post();
        post.setId(id);
        Comment commentSave = Comment.of(comment);
        commentSave.setUser(user);
        commentSave.setCreated(Calendar.getInstance());
        commentSave.setPost(post);
        post.addComment(commentSave);
        post.setUser(user);
        commentRepository.save(commentSave);
    }
}
