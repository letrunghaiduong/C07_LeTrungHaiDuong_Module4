package com.example.controller;

import com.example.dto.CartDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("cart")
public class CartController {
    @GetMapping
    public ModelAndView showCart(@SessionAttribute("cart") CartDto cart){
        return new  ModelAndView("cart/list","cart",cart);
    }
    @GetMapping("pay")
    public String remove(@SessionAttribute("cart")CartDto cart, RedirectAttributes redirectAttributes){

        cart.clear();
        redirectAttributes.addFlashAttribute("mess", "Pay successfully");
        return "redirect:/shop";
    }
}
