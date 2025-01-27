package com.ConnectAI.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    
    @RequestMapping("/dashboard")
    public String dashboard(){
       System.out.println("dashborad is running");
        return "user/dashboard";

    }

    @RequestMapping("/profile")
  public String profile(){
   System.out.println("profile page is running");
    return "user/profile";

  }

}
