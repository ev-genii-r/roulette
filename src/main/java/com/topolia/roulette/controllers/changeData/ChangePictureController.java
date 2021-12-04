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
public class ChangePictureController {
    @GetMapping("/change-picture")
    public String changePictureGet(){
        return "change-picture";
    }

    @PostMapping("/change-picture")
    public String changePicturePost(Model model,
                                     @RequestParam String picture,
                                     HttpServletRequest request){
        HttpSession session = request.getSession();
        DatabaseConnector connector = new DatabaseConnector();
        connector.changePicture((int)session.getAttribute("id"), picture);
        return "redirect:/user-page";
    }
}
