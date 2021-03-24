package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.User;
import ru.job4j.forum.repository.memory.UserMemory;

@Service
public class UserService {
    private UserMemory userMemory;

    public UserService(UserMemory userMemory) {
        this.userMemory = userMemory;
    }

    public void save(User user) {
        userMemory.create(user);
    }
}
