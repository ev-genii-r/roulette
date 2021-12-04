package com.topolia.roulette.controllers.changeData;

import com.topolia.roulette.dao.DatabaseConnector;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ChangeMoneyController {
    @GetMapping("/donat")
    public String donatGet(){
        return "donat";
    }

    @PostMapping("/donat")
    public String donatPost(@RequestParam String donat,
                            HttpServletRequest request){
        HttpSession session = request.getSession();
        DatabaseConnector databaseConnector = new DatabaseConnector();
        databaseConnector.changeBalance((int)session.getAttribute("balance_id"), Integer.parseInt(donat));
        return "redirect:/user-page";
    }
}
