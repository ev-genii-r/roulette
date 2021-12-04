package com.topolia.roulette.controllers.mainPages;

import com.topolia.roulette.beans.UserDatabaseData;
import com.topolia.roulette.dao.DatabaseConnector;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * controller for users page
 * @author Evgenii Rudkovskii
 * @version 1.0
 * @// TODO: 01.10.2021 add all users information
 * @// TODO: 01.10.2021 add edition form
 * @// TODO: 01.10.2021 add balance connection
 */
@Controller
public class UserPageController {
    @GetMapping("/user-page")
    public String loadUserPageGet(Model model, HttpServletRequest request){
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
        return "user-page";
    }
    @PostMapping("/user-page")
    public String loadUserPagePost(Model model){
        return "wallet";
    }
}
