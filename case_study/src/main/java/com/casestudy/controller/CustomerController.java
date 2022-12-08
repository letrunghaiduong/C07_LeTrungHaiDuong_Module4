package com.casestudy.controller;

import com.casestudy.model.customer.Customer;
import com.casestudy.service.customer.ICustomerService;
import com.casestudy.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("")
    public String customerList(Model model){
        model.addAttribute("customerList", customerService.findAll());
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        return "customer/list";
    }


    @GetMapping("/create")
    public  String createCustomer(Model model) {
        model.addAttribute("customerTypeList",customerTypeService.findAll());
        model.addAttribute("customer", new Customer());
        return "customer/create";
    }


    @PostMapping("/create")
    public String save(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "New customer created successfully");
        return "redirect:/customer";
    }


}
