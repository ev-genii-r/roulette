package com.topolia.roulette.controllers.changeData;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChangeInfoController {
    @GetMapping("/change-info")
    public String ChangeGet(){
        return "change-info";
    }
}
