package com.topolia.roulette.controllers.games;

import com.topolia.roulette.dao.DatabaseConnector;
import com.topolia.roulette.service.games.WheelSpeen;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class WheelSpinController {
    private static final int FIX_BET = 100;
    @GetMapping("/wheel-spin")
    public String loadWheelGet(){
        return "wheel-spin";
    }
    @PostMapping("/wheel-spin")
    public String loadWheelPost(Model model,
                                HttpServletRequest request){
        HttpSession session = request.getSession();
        DatabaseConnector connector = new DatabaseConnector();
        int prize = WheelSpeen.prize((String)session.getAttribute("sector"));
        connector.changeMoney(prize, (int)session.getAttribute("balance_id"));
        System.out.println("controller " + prize);
        return "wheel-spin";
    }
}