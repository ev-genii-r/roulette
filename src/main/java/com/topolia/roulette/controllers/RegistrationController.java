package com.topolia.roulette.controllers;

import com.topolia.roulette.exception.RegistrationException;
import com.topolia.roulette.service.RegistrationValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Evgenii Rudkovskii
 * @version 1.0
 */

@Controller
public class RegistrationController {

    @GetMapping("/registration")
    public String loadRegistrationGet(Model model){
        return "registration";
    }

    @PostMapping("/registration")
    public String loadRegistrationPost(Model model,
                                       @RequestParam String login,
                                       @RequestParam String password,
                                       @RequestParam String confirmPassword){

        try{
            if(RegistrationValidator.registrationTest(login, password, confirmPassword)){
                return "user-page";
            }
        }catch (RegistrationException ex){
            model.addAttribute("error", ex.getMessage());
        }
        return "registration";
    }
}
