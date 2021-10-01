package com.topolia.roulette.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * controller for users page
 * @author Evgenii Rudkovskii
 * @version 1.0
 * @// TODO: 01.10.2021 add all users information
 * @// TODO: 01.10.2021 add edition form
 * @// TODO: 01.10.2021 add balance connection
 */
@Controller
public class UserPageController {
    @GetMapping("/user-page")
    public String loadUserPageGet(Model model){
        return "user-page";
    }
    @PostMapping("/user-page")
    public String loadUserPagePost(Model model){
        return "user-page";
    }
}
