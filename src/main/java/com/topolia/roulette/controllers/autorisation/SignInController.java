package com.topolia.roulette.controllers.autorisation;

import com.topolia.roulette.dao.DatabaseConnector;
import com.topolia.roulette.exception.SignInException;
import com.topolia.roulette.service.autorisation.SignInCheck;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;
import java.sql.SQLException;

/**
 * @author Evgenii Rudkovskii
 * @version 1.0
 */
@Controller
public class SignInController {

    @GetMapping("/sign-in")
    public String loadSignInControllerGet(Model model ){
        return "sign-in";
    }

    @PostMapping("/sign-in")
    public String loadSignInControllerPost(Model model,
                                           @RequestParam String login,
                                           @RequestParam String password,
                                           HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("balance_id");
        try{
            DatabaseConnector connector = new DatabaseConnector();
            if(connector.isUserExists(login, password)){
                session.setAttribute("id", connector.getIdByLogin(login));
                return "redirect:/user-page";
            }
        }catch (Exception e){

        }
        model.addAttribute("error", "данного пользователя не существует");
        return "sign-in";
    }
}
