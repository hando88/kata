package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.userdetails.UserDetails;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> findById(Long id);

    List<User> getAll();

    User saveUser(User user);

    void deletedById(Long id);

    UserDetails loadUserByUsername(String username);

    void addTestUsers();
}
