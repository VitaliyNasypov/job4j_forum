package ru.job4j.forum.repository.memory;

import org.springframework.stereotype.Repository;
import ru.job4j.forum.model.Comment;

import java.util.Calendar;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class CommentMemory {
    private static final AtomicInteger COMMENT_ID = new AtomicInteger();
    private static final Map<Integer, Comment> COMMENTS = new ConcurrentHashMap<>();

    static {
        UserMemory userMemory = new UserMemory();
        CommentMemory commentMemory = new CommentMemory();
        Comment commentFirst = Comment.of("My first comment");
        commentFirst.setUser(userMemory.findById(1));
        commentMemory.create(commentFirst);
        Comment commentSecond = Comment.of("My second comment");
        commentSecond.setUser(userMemory.findById(1));
        commentMemory.create(commentSecond);
    }

    public Comment create(Comment comment) {
        comment.setId(COMMENT_ID.incrementAndGet());
        comment.setCreated(Calendar.getInstance());
        return COMMENTS.put(comment.getId(), comment);
    }

    public Comment findById(int id) {
        return COMMENTS.get(id);
    }
}
