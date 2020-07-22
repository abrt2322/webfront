package com.takedano.webfront;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Arrays;

@Controller
@RequestMapping("/")
public class WebController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    @RequestMapping(value = "answer", method = RequestMethod.GET)
    public String answer(@RequestParam()
                                     String value1, String value2, String value3, Model submit){
        int x,y,z;

        x = Integer.parseInt(value1);
        y = Integer.parseInt(value2);
        z = Integer.parseInt(value3);

        int[] h = {x,y,z};
        Arrays.sort(h);

        int H1 = (int) Math.pow(h[0],2);
        int H2 = (int) Math.pow(h[1],2);
        int H3 = (int) Math.pow(h[2],2);

        String flg;

        if(H1+H2==H3){
            flg = "Yes";
        }
        else {
            flg = "No";
        }

        submit.addAttribute("answer1", flg);

        return "answer";
    }
}
