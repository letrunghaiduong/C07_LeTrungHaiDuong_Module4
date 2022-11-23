package com.codegym.controller;

import com.codegym.model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmailController {
    @GetMapping("")
    public String showForm(Model model){
        model.addAttribute("email",new Email());
        return "/create";
    }

    @PostMapping("save")
    public String saveForm(@ModelAttribute("email") Email email, Model model){
        model.addAttribute("email",email);
        return "/list";
    }
}
