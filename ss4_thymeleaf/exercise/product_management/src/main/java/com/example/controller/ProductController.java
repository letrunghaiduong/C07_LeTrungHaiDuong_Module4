package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;
@Controller
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping("")
    public String list(Model model){
        List<Product> productList = iProductService.findAll();
        model.addAttribute("productList",productList);
        return "list";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("product",new Product());
        return "create";
    }
    @PostMapping("/save")
    public String save(Product product,RedirectAttributes redirectAttributes){
        product.setId((int) (Math.random() * 10000));
        iProductService.save(product);
        redirectAttributes.addFlashAttribute("mess","Add success");
        return "create";
    }
    @GetMapping("/edit")
    public String edit(@RequestParam int id, Model model){
        model.addAttribute("product", iProductService.findById(id));
        return "edit";
    }
    @PostMapping("/update")
    public String update(Product product){
        iProductService.update(product.getId(),product);
        return "list";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("deleteById") int deleteById ){
        iProductService.remove(deleteById);
        return "redirect:list";
    }
    @GetMapping("/view")
    public String view(@RequestParam int id,Model model){
        model.addAttribute("productList",iProductService.findById(id));
        return "list";
    }
    @PostMapping("/search")
    public String search(@RequestParam String search,Model model){
        List<Product> productList=iProductService.findByName(search);
        model.addAttribute("productList",productList);
        return "list";
    }
}
