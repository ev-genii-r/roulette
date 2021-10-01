package com.topolia.roulette.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactsController {
    @GetMapping("/contacts")
    public String loadContactGet(Model model){
        return "contacts";
    }
    @PostMapping("/contacts")
    public String loadContactPost(Model model){
        return "contacts";
    }
}
