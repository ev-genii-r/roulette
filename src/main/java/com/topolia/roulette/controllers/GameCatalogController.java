package com.topolia.roulette.controllers;

import com.topolia.roulette.beans.UserPresentationData;
import com.topolia.roulette.service.UserPresentationDataGetter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * controller for game catalog page
 * @author Evgenii Rudkovskii 
 * @version 1.0
 * @// TODO: 01.10.2021 postMapping with buttons: all games, all pages 
 */
@Controller
public class GameCatalogController {

    @GetMapping("/game-catalog")
    public String greeting(Model model) {
        UserPresentationDataGetter getter = new UserPresentationDataGetter();
        UserPresentationData user = new UserPresentationData();
        user = getter.testPossibility(2);
        model.addAttribute("name", user.getName());
        model.addAttribute("id", user.getId());
        return "gameCatalog";
    }

}