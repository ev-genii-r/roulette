package com.topolia.roulette.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Evgenii Rudkovskii
 * @version 1.0
 */

@Controller
public class HomePageController {
    @GetMapping("/")
    public String loadHomePageGet(Model model){
        return "home-page";
    }

    @PostMapping("/")
    public String loadHomePagePost(Model model){
        return "home-page";
    }
}
