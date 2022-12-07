package com.example.room_for_rental_children.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class homeController {
@GetMapping
    public String home(){
        return "home";
    }
}
