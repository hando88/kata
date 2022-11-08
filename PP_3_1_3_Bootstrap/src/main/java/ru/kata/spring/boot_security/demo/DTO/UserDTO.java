package ru.kata.spring.boot_security.demo.DTO;

import lombok.Data;
import ru.kata.spring.boot_security.demo.model.Role;

import java.util.Collection;

@Data
public class UserDTO {
    private Long id;
    private String name;
    private String password;
    private Collection<Role> userRoles;

}
