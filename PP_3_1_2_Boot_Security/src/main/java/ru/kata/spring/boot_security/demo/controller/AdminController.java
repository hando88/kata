package ru.kata.spring.boot_security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;
import java.util.Objects;

@Controller
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

    @GetMapping("/admin")
    public String adminPage(Model model) {
        model.addAttribute("users", userService.getAll());
        return "/admin";
    }

    @GetMapping("/create")
    public String createUserForm(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("roles", roleService.getAllRoles());
        return "/create";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute("user") User user,
                             @RequestParam(value = "nameRoles", required = false) String roles) {
        user.setUserRoles(roleService.getRoleByName(Objects.requireNonNullElse(roles, "ROLE_USER")));
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deletedById(id);
        return "redirect:/admin";
    }


    @GetMapping("/update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        model.addAttribute("roles", roleService.getAllRoles());
        return "/update";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") User user,
                             @RequestParam(value = "nameRoles", required = false) String roles) {
        user.setUserRoles(roleService.getRoleByName(Objects.requireNonNullElse(roles, "ROLE_USER")));
        userService.saveUser(user);
        return "redirect:/admin";
    }
}
