package ru.kata.spring.boot_security.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;

@RestController
public class UserController {
    private final UserService userService;

    private final RoleService roleService;

    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
        userService.addTestUsers();
    }

    @PostConstruct
    public void addTestUsers() {
        userService.saveUser(new User("admin", "admin", roleService.getRoleByName("ROLE_ADMIN")));
        userService.saveUser(new User("user", "user", roleService.getRoleByName("ROLE_USER")));
    }


    @GetMapping("/user")
    public String userPage() {
        return "user";
    }

    @GetMapping("/info")
    public ResponseEntity<?> getUser() {
        UserDetails userDetails
                = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.findUserByUsername(userDetails.getUsername());
        return ResponseEntity.ok().body(user);
    }
}
