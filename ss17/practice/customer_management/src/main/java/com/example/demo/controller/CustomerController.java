package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("")
    public String listCustomers(Model model) {
        model.addAttribute("customers", customerService.findAll());
        return "list";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("customer",new Customer());
        return "create";
    }
    @PostMapping("/create")
    public String saveCustomer(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "New customer created successfully");
        return "list";
    }
    @GetMapping("/edit")
    public String showEditForm(@RequestParam long id, Model model) {
        model.addAttribute("product", customerService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String updateCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        return "list";
    }
}
