package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.DTO.UserDTO;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    void saveUser(User user);

    void deletedById(Long id);

    void addTestUsers();

    User findUserByUsername(String name);

    User convertToUser(UserDTO userDTO);

    User getUserById(Long id);

    UserDTO convertToDTO(User user);
}
