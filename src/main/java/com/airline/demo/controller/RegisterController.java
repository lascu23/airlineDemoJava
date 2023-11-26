package com.airline.demo.controller;

import com.airline.demo.entity.RegistrationRequest;
import com.airline.demo.entity.User;
import com.airline.demo.exception.UserRegistrationException;
import com.airline.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String displayRegisterPage(Model model){
        model.addAttribute("person", new User());
        return "register";
    }

    @PostMapping("/createUser")
    public ModelAndView registerUser(@ModelAttribute RegistrationRequest request){
        ModelAndView modelAndView = new ModelAndView();

        try {
            userService.registerUser(request.getEmail(), request.getPassword(), request.getName());
            modelAndView.addObject("message", "Utilizator înregistrat cu succes!");
            modelAndView.setViewName("redirect:/home"); // Numele paginii HTML de succes
        } catch (UserRegistrationException e) {
            modelAndView.addObject("error", "Adresa de mail a fost deja inregistrata!");
            modelAndView.setViewName("redirect:/register"); // Numele paginii HTML de eroare
        }

        return modelAndView;
    }
}
