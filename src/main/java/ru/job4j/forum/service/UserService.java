package ru.job4j.forum.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.job4j.forum.model.User;
import ru.job4j.forum.repository.data.AuthorityRepository;
import ru.job4j.forum.repository.data.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final AuthorityRepository authorities;

    public UserService(PasswordEncoder encoder, UserRepository userRepository,
                       AuthorityRepository authorities) {
        this.encoder = encoder;
        this.userRepository = userRepository;
        this.authorities = authorities;
    }

    @Transactional(rollbackFor = Exception.class)
    public void save(User user) {
        user.setEnabled(true);
        user.setPassword(encoder.encode(user.getPassword()));
        user.setAuthority(authorities.findByAuthority("ROLE_USER"));
        userRepository.save(user);
    }

    public User findByName(String name) {
        return userRepository.findByUsername(name);
    }
}
