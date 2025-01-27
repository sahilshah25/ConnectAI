package com.ConnectAI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ConnectAI.entities.User;
import com.ConnectAI.forms.UserForms;
import com.ConnectAI.service.UserService;

import jakarta.validation.Valid;


@Controller

public class PageController {

    @Autowired
    private UserService userService;

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

    @RequestMapping("/ragister")
    public String ragister(Model model){
        System.out.println("ragister page is running");
        
        UserForms userForm=new UserForms();
        
        model.addAttribute("userForm", userForm);
        return"ragister";
    }

    //processing register form 
    

      @RequestMapping( value = "/do-register",method = RequestMethod.POST)
    public String processRegister(@Valid @ModelAttribute UserForms userForms,BindingResult bindingResult,Model model){
        System.out.println("processing ragistration");
        System.out.println(userForms);


        //fetch data
        //validate data
        // if(bindingResult.hasErrors()){
        //     return "/ragister";
        // }
        //save data
       User user= new User();
       user.setEmail(userForms.getEmail());
       user.setAbout(userForms.getAbout());
       user.setName(userForms.getName());
       user.setPassword(userForms.getPassword());
       user.setPhoneNumber(userForms.getPhoneNumber());


        User savedUser=userService.saveUser(user);
        System.out.println("saved user");
        //message ="registration successfully"
        //redirect to login page
        return"redirect:/ragister";
    }

}
