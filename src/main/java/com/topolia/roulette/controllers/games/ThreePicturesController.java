package com.topolia.roulette.controllers.games;

import com.topolia.roulette.dao.DatabaseConnector;
import com.topolia.roulette.service.games.ThreePictures;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ThreePicturesController {

    @GetMapping("/three-pictures")
    public String threePictureGet(Model model){
        model.addAttribute("img1", "img/empty.png");
        model.addAttribute("img2", "img/empty.png");
        model.addAttribute("img3", "img/empty.png");
        model.addAttribute("img4", "img/empty.png");
        model.addAttribute("img5", "img/empty.png");
        model.addAttribute("img6", "img/empty.png");
        model.addAttribute("img7", "img/empty.png");
        model.addAttribute("img8", "img/empty.png");
        model.addAttribute("img9", "img/empty.png");
        return "three-pictures";
    }

    @PostMapping("/three-pictures")
    public String threePicturesPost(Model model,
                                    @RequestParam String select1,
                                    @RequestParam String select2,
                                    @RequestParam String select3,
                                    @RequestParam String bet,
                                    HttpServletRequest request){
        HttpSession session = request.getSession();
        DatabaseConnector connector = new DatabaseConnector();
        int[] ms = ThreePictures.getRandomPosition();
        String[] resMs = new String[9];
        for(int i = 0 ; i < 9 ; i++){
            if(ms[i] == 1){
                resMs[i] = "img/pict1.png";
            }else if(ms[i] == 2){
                resMs[i] = "img/pict2.png";
            }else {
                resMs[i] = "img/pict3.png";
            }
        }
        int s1 = Integer.parseInt(select1)-1;
        int s2 = Integer.parseInt(select2)-1;
        int s3 = Integer.parseInt(select3)-1;
        if(ms[s1]==ms[s2] && ms[s2] == ms[s3]){
            if(ms[s1] == 1){
                connector.changeBalance((int)session.getAttribute("balance_id"),
                        Integer.parseInt(bet)*20);
            }
            if(ms[s1] == 2){
                connector.changeBalance((int)session.getAttribute("balance_id"),
                        Integer.parseInt(bet)*100);
            }
            if(ms[s1] == 3){
                connector.changeBalance((int)session.getAttribute("balance_id"),
                        Integer.parseInt(bet)*50);
            }
        }else {
            connector.changeBalance((int)session.getAttribute("balance_id"),
                    Integer.parseInt(bet)*(-1));
        }
        model.addAttribute("img1", resMs[0]);
        model.addAttribute("img2", resMs[1]);
        model.addAttribute("img3", resMs[2]);
        model.addAttribute("img4", resMs[3]);
        model.addAttribute("img5", resMs[4]);
        model.addAttribute("img6", resMs[5]);
        model.addAttribute("img7", resMs[6]);
        model.addAttribute("img8", resMs[7]);
        model.addAttribute("img9", resMs[8]);
        return "three-pictures";
    }

}
