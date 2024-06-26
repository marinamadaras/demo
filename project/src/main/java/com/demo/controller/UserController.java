package com.demo.controller;

import com.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @GetMapping("/user")
    public String userForm(Model model) {
        model.addAttribute("user", new User(1,"John", "email"));
        return "user";
    }

    @PostMapping("/saveUser")
    public String saveUser(@RequestParam("userId") int userId,
                           @RequestParam("name") String name,
                           @RequestParam("email") String email,
                           Model model) {
        User user = new User(userId, name, email);
        model.addAttribute("user", user);
        return "result";
    }
}
