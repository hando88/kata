package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.Role;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface RoleService {
    List<Role> getAllRoles();

    Optional<Role> getRoleById(Long id);

    Collection<Role> getRoleByName(String rollName);

    void addRole(Role role);

    void getRoles();
}
