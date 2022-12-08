package com.casestudy.controller;

import com.casestudy.model.customer.Customer;
import com.casestudy.service.customer.ICustomerService;
import com.casestudy.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("")
    public String customerList(Model model, @PageableDefault(page = 0,size = 3) Pageable pageable){
        model.addAttribute("customerList", customerService.finAllCustomer(pageable));
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

    @GetMapping("/edit")
    public  String editCustomer(@RequestParam Integer id, Model model) {
        model.addAttribute("customerTypeList",customerTypeService.findAll());
        model.addAttribute("customer",customerService.findById(id));
        return "customer/edit";
    }


    @PostMapping("/update")
    public String update(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Edit successfully");
        return "redirect:/customer";
    }


    @GetMapping("/delete")
    public String delete(@RequestParam("deleteById") int deleteById ){
        customerService.remove(deleteById);
        return "redirect:/customer";
    }
}
