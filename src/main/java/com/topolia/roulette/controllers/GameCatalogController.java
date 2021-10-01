package com.topolia.roulette.controllers;

import com.topolia.roulette.beans.UserPresentationData;
import com.topolia.roulette.service.UserPresentationDataGetter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String loadCatalogGet(Model model) {
        UserPresentationDataGetter getter = new UserPresentationDataGetter();
        UserPresentationData user = new UserPresentationData();
        user = getter.testPossibility(2);
        model.addAttribute("name", user.getName());
        model.addAttribute("id", user.getId());
        return "game-catalog";
    }
    @PostMapping("/game-catalog")
    public String loadCatalogPost(Model model){
        return  "game-catalog";
    }
}