package com.topolia.roulette.controllers.changeData;

import com.topolia.roulette.dao.DatabaseConnector;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ChangePasswordController {
    @GetMapping("/change-password")
    public String changePasswordGet(){
        return "change-password";
    }

    @PostMapping("/change-password")
    public String changePasswordPost(Model model,
                                     @RequestParam String oldPassword,
                                     @RequestParam String newPassword,
                                     @RequestParam String newPasswordRep,
                                     HttpServletRequest request){
        HttpSession session = request.getSession();
        if(newPassword.equals(newPasswordRep)){
            DatabaseConnector connector = new DatabaseConnector();
            connector.changePassword((int)session.getAttribute("id"), oldPassword, newPassword);
        }
        return "redirect:/user-page";
    }
}
