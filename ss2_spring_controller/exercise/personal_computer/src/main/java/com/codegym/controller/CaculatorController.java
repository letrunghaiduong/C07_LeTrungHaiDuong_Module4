package com.codegym.controller;

import com.codegym.service.ICaculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CaculatorController {
    @Autowired
    private ICaculatorService iCaculatorService;
    @GetMapping("")
    public String getCaculator(){
        return "index";
    }

    @PostMapping("")
    public String caculator(@RequestParam("number1") int number1,
                             @RequestParam("number2") int number2,
                             @RequestParam("calculation") String calculation,
                             Model model){
        double result = iCaculatorService.caculator(calculation,number1,number2);
        model.addAttribute("result",result);
        return "index";
    }
}
