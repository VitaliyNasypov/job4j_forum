package ru.job4j.forum.repository.memory;

import org.springframework.stereotype.Repository;
import ru.job4j.forum.model.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class UserMemory {
    private static final AtomicInteger USER_ID = new AtomicInteger();
    private static final Map<Integer, User> USERS = new ConcurrentHashMap<>();

    static {
        User user = User.of("Admin");
        user.setPassword("Admin");
        UserMemory userMemory = new UserMemory();
        userMemory.create(user);
    }

    public User create(User user) {
        user.setId(USER_ID.incrementAndGet());
        return USERS.put(user.getId(), user);
    }

    public User findById(int id) {
        return USERS.get(id);
    }
}
