package com.topolia.roulette.controllers.autorisation;

import com.topolia.roulette.beans.UserDatabaseData;
import com.topolia.roulette.dao.DatabaseConnector;
import com.topolia.roulette.exception.RegistrationException;
import com.topolia.roulette.service.autorisation.RegistrationValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
                                       @RequestParam String confirmPassword,
                                       @RequestParam String image,
                                       HttpServletRequest request){

        try{
            HttpSession session = request.getSession();
            session.removeAttribute("balance_id");
            if(RegistrationValidator.registrationTest(login, password, confirmPassword)){
                DatabaseConnector databaseConnector = new DatabaseConnector();
                String usrImage;
                if(image == null || image == ""){
                    usrImage = "img/ava.png";
                }else{
                    usrImage = image;
                }
                UserDatabaseData user = new UserDatabaseData(login, password, usrImage);
                databaseConnector.addUser(user);
                session.setAttribute("id", databaseConnector.getIdByLogin(login));
                return "redirect:/user-page";
            }

        }catch (RegistrationException ex){
            model.addAttribute("error", ex.getMessage());
        }
        return "registration";
    }
}
