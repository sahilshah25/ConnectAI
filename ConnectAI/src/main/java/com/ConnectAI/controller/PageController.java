package com.ConnectAI.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller

public class PageController {

     @RequestMapping("/home")
    public String home(Model model){
        model.addAttribute("message", "hello this is from home hnadler");
        model.addAttribute("name", "sahil ahmad shah");
        model.addAttribute("college", "sharda university");
        model.addAttribute("gitHub", "https://github.com/sahilshah25");
        return "home";
    }
    @RequestMapping("/about")
    public String about(){
        System.out.println("about is running");
        return "about";
    }
    
    @RequestMapping("/service")
    public String service(){
        System.out.println("service is running");
        return "service";

    }

}
