package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("")
    public String listBlog(Model model) {
        model.addAttribute("userList", userService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("user", new User());
        return "create";
    }

    @PostMapping("/create")
    public String save(@Validated @ModelAttribute("user") User user, BindingResult bindingResult,
                       RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()){
            return "create";
        }
        userService.save(user);
        redirectAttributes.addFlashAttribute("message", "New user created successfully");
        return "redirect:/create";
    }

}
