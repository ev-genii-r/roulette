package com.topolia.roulette.controllers.games;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GraphController {
    @GetMapping ("/graph")
    public String graphGet(Model model){
        String[] blocks = new String[]{"block1", "block2", "block3", "block4"};
        model.addAttribute("block", blocks);
        return "graph";
    }

    @PostMapping("/graph")
    public String graphPost(Model model){
        return "graph";
    }
}
