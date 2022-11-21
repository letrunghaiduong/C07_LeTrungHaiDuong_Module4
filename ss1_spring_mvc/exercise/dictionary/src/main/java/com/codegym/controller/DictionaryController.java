package com.codegym.controller;

import com.codegym.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
@Controller
public class DictionaryController {
    @Autowired
    private IDictionaryService iDictionaryService;
    @GetMapping("")
    public String show(){
        return "index";
    }
    @PostMapping("")
    public String dictionary(String value, Model model){
        String map = iDictionaryService.search().get(value);
        model.addAttribute("map",map);
        return "index";
    }
}
