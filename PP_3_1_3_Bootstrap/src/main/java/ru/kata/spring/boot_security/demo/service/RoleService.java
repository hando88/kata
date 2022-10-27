package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.Role;

import java.util.Collection;
import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();

    Collection<Role> getRoleByName(String rollName);

    void getRoles();
}
