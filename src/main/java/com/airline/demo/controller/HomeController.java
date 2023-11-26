package com.airline.demo.controller;

import com.airline.demo.entity.Flight;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping(value = {"","/","/home"})
    public String getHome(Model model){
        Flight flight = new Flight();
        model.addAttribute("flight", flight);
        return "home.html";
    }
}
