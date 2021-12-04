package com.topolia.roulette.controllers.games;

import com.topolia.roulette.beans.UserDatabaseData;
import com.topolia.roulette.dao.DatabaseConnector;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class ChanceController {
    @GetMapping ("/chance")
    public String chanceGet(Model model,
                            HttpServletRequest request){
        HttpSession session = request.getSession();
        int id = (Integer)session.getAttribute("id");
        DatabaseConnector databaseConnector = new DatabaseConnector();
        UserDatabaseData user = databaseConnector.getUser(id);
        model.addAttribute("name", user.getLogin());
        model.addAttribute("image", user.getImage());
        try {
            model.addAttribute("balance", databaseConnector.getWallet((int) session.getAttribute("balance_id")));
        }catch (Exception ex){

        }
        return "chance";
    }
    @PostMapping("/chance")
    public String chancePost(Model model,
                             @RequestParam int bet,
                             @RequestParam int chose,
                             HttpServletRequest request){
        Date date = new Date();
        HttpSession session = request.getSession();
        DatabaseConnector connector = new DatabaseConnector();
        int id = (Integer)session.getAttribute("id");
        UserDatabaseData user = connector.getUser(id);
        model.addAttribute("name", user.getLogin());
        model.addAttribute("image", user.getImage());
        try {
            model.addAttribute("balance", connector.getWallet((int) session.getAttribute("balance_id")));
        }catch (Exception ex){

        }
        int result = -bet;
        int random = (int)(date.getTime()%100);
        switch (chose){
            case 2: if(random < 75){
                result = (int)(bet*1.2);
            }
                break;
            case 4: if(random < 70){
                result = (int)(bet*1.4);
            }
                break;
            case 6: if(random < 60){
                result = (int)(bet*1.6);
            }
                break;
            case 8: if(random < 50){
                result = (int)(bet*1.8);
            }
                break;
            case 20: if(random < 40){
                result = (int)(bet*2);
            }
                break;
        }
        connector.changeBalance((int)session.getAttribute("balance_id"), result);
        model.addAttribute("win", result);
        return "chance";
    }
}
