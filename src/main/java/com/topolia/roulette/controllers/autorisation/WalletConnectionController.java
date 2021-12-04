package com.topolia.roulette.controllers.autorisation;

import com.topolia.roulette.beans.UserDatabaseData;
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
public class WalletConnectionController {

    @GetMapping("/wallet")
    public String loadWalletControllerGet(Model model,
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
        return "wallet";
    }

    @PostMapping("/wallet")
    public String loadWalletControllerPost(Model model,
                                           @RequestParam String bill_number,
                                           @RequestParam String password, HttpServletRequest request){
        try{
            DatabaseConnector connector = new DatabaseConnector();
            HttpSession session = request.getSession();
            int id = (Integer)session.getAttribute("id");
            UserDatabaseData user = connector.getUser(id);
            model.addAttribute("name", user.getLogin());
            model.addAttribute("image", user.getImage());
            try {
                model.addAttribute("balance", connector.getWallet((int) session.getAttribute("balance_id")));
            }catch (Exception ex){

            }
            if(connector.isWalletExists(bill_number,password)){
                session.setAttribute("balance_id", connector.getWallet(bill_number, password));
                System.out.println(session.getAttribute("balance_id"));
                return "redirect:/user-page";
            }

        }catch (Exception ex){
            model.addAttribute("error", "ошибка");
        }
        return "wallet";
    }
}
