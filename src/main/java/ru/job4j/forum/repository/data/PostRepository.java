package ru.job4j.forum.repository.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.job4j.forum.model.Post;

public interface PostRepository extends CrudRepository<Post, Integer> {
    @Override
    @Query("select distinct p from Post p join fetch p.user")
    Iterable<Post> findAll();
}