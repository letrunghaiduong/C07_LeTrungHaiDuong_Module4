package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @GetMapping("/home")
    public String home(){
        return "home";
    }


    @GetMapping("/login")
    public String login(){
        return "formLogin";
    }


    @GetMapping("/user")
    public String userLoginSuccess(){
        return "user";
    }


    @GetMapping("/admin")
    public String adminLoginSuccess(){
        return "admin";
    }


}
