package ru.job4j.forum.repository.data;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.job4j.forum.model.Post;

public interface PostRepository extends CrudRepository<Post, Integer> {
    @Modifying
    @Query("update Post p set p.name = :name, p.description = :description where p.id = :id")
    void update(@Param("id") int id, @Param("name") String name,
                @Param("description") String description);
}