package com.topolia.roulette.controllers.autorisation;

import com.topolia.roulette.exception.SignInException;
import com.topolia.roulette.service.autorisation.SignInCheck;
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
public class SignInController {

    @GetMapping("/sign-in")
    public String loadSignInControllerGet(Model model){
        return "sign-in";
    }

    @PostMapping("/sign-in")
    public String loadSignInControllerPost(Model model,
                                           @RequestParam String login,
                                           @RequestParam String password){
        try{
            if(SignInCheck.doesItExist(login, password)){
                return "user-page";
            }
        }catch (SignInException ex){
            model.addAttribute("error", ex.getMessage());
        }
        return "sign-in";
    }
}
