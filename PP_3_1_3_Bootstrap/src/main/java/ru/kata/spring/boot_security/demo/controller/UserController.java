package ru.kata.spring.boot_security.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
        userService.addTestUsers();
    }

    @GetMapping
    public String getUsers(Authentication auth, Model model) {
        model.addAttribute("user", userService.findUserByUsername(auth.getName()));
        return "user/user";
    }
}
