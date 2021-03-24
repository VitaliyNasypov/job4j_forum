package ru.job4j.forum.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class Post {
    private int id;
    private String name;
    private String desc;
    private Calendar created;
    private Set<Comment> comments;
    private User user;

    public static Post of(String name) {
        Post post = new Post();
        post.name = name;
        return post;
    }

    public String getFormattedCalendar() {
        SimpleDateFormat fmt = new SimpleDateFormat("dd.MM.yyyy");
        return fmt.format(this.created.getTime());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Post post = (Post) o;
        return id == post.id
                && Objects.equals(name, post.name)
                && Objects.equals(desc, post.desc)
                && Objects.equals(created, post.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, desc, created);
    }
}
