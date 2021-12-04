package com.topolia.roulette.controllers.games;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class RestWheelController {
    @PostMapping("/sector")
    public int getSector(HttpServletRequest request){
        HttpSession session = request.getSession();
        String sector = request.getHeader("sector");
        session.setAttribute("sector", sector);
        System.out.println(sector);
        return Integer.parseInt(sector);
    }
}
