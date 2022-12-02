package com.example.controller;

import com.example.dto.CartDto;

import com.example.dto.ProductDto;
import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
@SessionAttributes("cart")
@RequestMapping("/shop")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public CartDto showCart() {
        return new CartDto();
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @SessionAttribute("cart") CartDto cartDto) {
        Optional<Product> product = productService.findById(id);
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product.get(),productDto);
        cartDto.addProduct(productDto);
        return "redirect:/cart";
    }
    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable Long id, HttpServletResponse response,Model model){
        Cookie cookie = new Cookie("idProduct",String.valueOf(id));
        cookie.setMaxAge(30);
        cookie.setPath("/");
        response.addCookie(cookie);
        model.addAttribute("product",productService.findById(id).get());
        return "product/detail";
    }
    @GetMapping
    public String showListPage(Model model,@CookieValue(value = "idProduct",defaultValue = "-1") Long idProduct){
        if (idProduct!= -1){
            model.addAttribute("historyProduct",productService.findById(idProduct).get());
        }
        model.addAttribute("productList",productService.findAll());
        return "product/list";
    }
}