package ru.job4j.forum.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.job4j.forum.model.User;
import ru.job4j.forum.repository.data.UserRepository;

@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldFindUserByName() {
        User userFind = userRepository.findByUsername("Username_Test");
        Assertions.assertEquals(1, userFind.getId());
        Assertions.assertEquals("Username_Test", userFind.getUsername());
    }
}
