package ru.kata.spring.boot_security.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;
import java.util.Objects;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }


    @PostConstruct
    public void addTestUsers() {
        userService.saveUser(new User("admin", "admin", roleService.getRoleByName("ROLE_ADMIN")));
        userService.saveUser(new User("user", "user", roleService.getRoleByName("ROLE_USER")));
    }

    @GetMapping
    public String adminPage(@ModelAttribute("user") User user, Model model, Authentication authentication) {
        model.addAttribute("users", userService.getAll());
        model.addAttribute("principal", authentication);
        model.addAttribute("rolesList", roleService.getAllRoles());
        model.addAttribute("admin", userService.findUserByUsername(authentication.getName()));
        return "admin/admin";
    }

    @DeleteMapping("/edit/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deletedById(id);
        return "redirect:/admin";
    }

    @PatchMapping("/edit/{id}")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @PostMapping("/new")
    public String addNewUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/admin";
    }
}
