package ru.job4j.forum.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Calendar;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public class Comment {
    private int id;
    private String text;
    private Calendar created;
    private User user;

    public static Comment of(String text) {
        Comment comment = new Comment();
        comment.text = text;
        return comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Comment comment = (Comment) o;
        return id == comment.id
                && Objects.equals(text, comment.text)
                && Objects.equals(created, comment.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, created);
    }
}
