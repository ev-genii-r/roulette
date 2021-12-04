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
public class ChangeLoginController {

    @GetMapping("/change-login")
    public String changeLoginGet(){
        return "change-login";
    }

    @PostMapping("/change-login")
    public String changeLoginPost(Model model,
                                  @RequestParam String newLogin,
                                  HttpServletRequest request){
        HttpSession session = request.getSession();
        DatabaseConnector connector = new DatabaseConnector();
        connector.changeLogin((int)session.getAttribute("id"), newLogin);
        return "redirect:/user-page";
    }
}
