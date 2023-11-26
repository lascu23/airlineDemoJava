package com.airline.demo.controller;

import com.airline.demo.entity.User;
import com.airline.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;


    @GetMapping("/login")
    public String displayRegisterPage(Model model){
        model.addAttribute("person", new User());
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {
        User user = userService.login(email, password);
        if (user != null) {
            return "Autentificare cu succes!";
        } else {
            return "Autentificare eșuată!";
        }
    }
}
