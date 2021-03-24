package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.User;
import ru.job4j.forum.repository.data.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public User findById(int id) {
        return userRepository.findById(id).orElse(new User());
    }
}
