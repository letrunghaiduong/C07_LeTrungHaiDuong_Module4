package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.IConvertService;
import service.impl.ConvertService;

@Controller
@RequestMapping("")
public class ConvertController {
    private IConvertService iconvertService = new ConvertService();

    @RequestMapping("")
    public String convert(@RequestParam(defaultValue = "0") double usd, Model model){
        double vnd = iconvertService.convert(usd);
        model.addAttribute("vnd",vnd);
        return "index";
    }
}
