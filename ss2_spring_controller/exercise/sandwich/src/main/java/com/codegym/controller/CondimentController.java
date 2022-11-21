package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class CondimentController {
    @GetMapping("")
    public String getSave(){
        return "index";
    }

    @PostMapping("")
    public String save(@RequestParam("condiment") String condiment, Model model){
        List<String> condimentList = new ArrayList<>();
        if (condiment!=""){
            condimentList.add(condiment);
        }
        model.addAttribute("condimentList",condimentList.toString());
        return "index";
    }
}
