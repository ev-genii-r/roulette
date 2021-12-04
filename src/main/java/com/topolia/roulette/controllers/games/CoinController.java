package com.topolia.roulette.controllers.games;

import com.topolia.roulette.beans.UserDatabaseData;
import com.topolia.roulette.dao.DatabaseConnector;
import org.apache.tomcat.jni.Time;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class CoinController {
    @GetMapping("/coin")
        public String loadContactGet(Model model,
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
            model.addAttribute("result", "img/empty.png");
            return "coin";
        }
        @PostMapping("/coin")
        public String loadContactPost(Model model, @RequestParam String bet, @RequestParam int selection, HttpServletRequest request){
            HttpSession session = request.getSession();
            int id = (Integer)session.getAttribute("id");
            System.out.println(selection);
            DatabaseConnector databaseConnector = new DatabaseConnector();
            UserDatabaseData user = databaseConnector.getUser(id);
            model.addAttribute("name", user.getLogin());
            model.addAttribute("image", user.getImage());
            try {
                model.addAttribute("balance", databaseConnector.getWallet((int) session.getAttribute("balance_id")));
            }catch (Exception ex){

            }
            databaseConnector.changeBalance((int)session.getAttribute("balance_id"), -1*Integer.parseInt(bet));
            Date date = new Date();
            int res =(int)(date.getTime()%2);
            if(res == 1){
                model.addAttribute("result", "img/орёл.png");
                model.addAttribute("coin", "Орёл");
                if(selection == 0){
                    databaseConnector.changeBalance((int)session.getAttribute("balance_id"), (int)(Integer.parseInt(bet)*1.8));
                    model.addAttribute("win", Integer.parseInt(bet)*1.8);
                }else {
                    model.addAttribute("win", 0);
                }
            }else {
                model.addAttribute("result", "img/решка.png");
                model.addAttribute("coin", "Решка");
                if(selection == 1){
                    databaseConnector.changeBalance((int)session.getAttribute("balance_id"), (int)(Integer.parseInt(bet)*1.8));
                    model.addAttribute("win", Integer.parseInt(bet)*1.8);
                }else {
                    model.addAttribute("win", 0);
                }
            }
            return "coin";
        }
}
