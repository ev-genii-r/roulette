package com.topolia.roulette.controllers.mainPages;

import com.topolia.roulette.beans.UserDatabaseData;
import com.topolia.roulette.beans.UserPresentationData;
import com.topolia.roulette.dao.DatabaseConnector;
import com.topolia.roulette.service.UserPresentationDataGetter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * controller for game catalog page
 * @author Evgenii Rudkovskii 
 * @version 1.0
 * @// TODO: 01.10.2021 buttons: all games
 * @// TODO: 01.10.2021 creat all post fields
 */
@Controller
public class GameCatalogController {

    @GetMapping("/game-catalog")
    public String loadCatalogGet(Model model, HttpServletRequest request) {
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
        return "game-catalog";
    }
    @PostMapping("/game-catalog")
    public String loadCatalogPost(Model model){
        return  "wallet";
    }
}