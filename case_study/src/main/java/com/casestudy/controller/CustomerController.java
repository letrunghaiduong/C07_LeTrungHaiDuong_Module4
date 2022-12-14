package com.casestudy.controller;

import com.casestudy.model.customer.Customer;
import com.casestudy.service.customer.ICustomerService;
import com.casestudy.service.customer.ICustomerTypeService;
import com.casestudy.dto.CustomerDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
    public String customerList(@PageableDefault(page = 0,size = 4) Pageable pageable,
                               @RequestParam( required = false, defaultValue = "") String name,
                               @RequestParam( required = false, defaultValue = "") String email,
                               @RequestParam( required = false, defaultValue = "") String customerTypeId,
                               Model model){
        Page<Customer> customerList =customerService.searchCustomer(name,email,customerTypeId,pageable);
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        model.addAttribute("customerList",customerList);
        model.addAttribute("name",name);
        model.addAttribute("email",email);
        model.addAttribute("customerTypeId",customerTypeId);
//        model.addAttribute("customerList", customerService.findAll(pageable));

        return "customer/list";
    }


    @GetMapping("/create")
    public  String createCustomer(Model model) {
        model.addAttribute("customerTypeList",customerTypeService.findAll());
        model.addAttribute("customer", new Customer());
        return "/customer/create";
    }


    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("customer") CustomerDTO customerDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
        model.addAttribute("customerTypeList",customerTypeService.findAll());
        if (bindingResult.hasErrors()){
            return "/customer/create";
        }

        Customer customer=new Customer();

        BeanUtils.copyProperties(customerDTO,customer);
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message","Create new customer SussesFully");
        return "redirect:/customer";
    }

    @GetMapping("/edit")
    public  String editCustomer(@RequestParam Integer id, Model model) {
        model.addAttribute("customerTypeList",customerTypeService.findAll());
        model.addAttribute("customer",customerService.findById(id));
        return "/customer/edit";
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
