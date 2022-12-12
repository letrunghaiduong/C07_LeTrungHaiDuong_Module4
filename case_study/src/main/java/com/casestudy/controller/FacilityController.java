package com.casestudy.controller;


import com.casestudy.dto.CustomerDTO;
import com.casestudy.dto.FacilityDTO;
import com.casestudy.model.customer.Customer;
import com.casestudy.model.facility.Facility;
import com.casestudy.service.facility.IFacilityService;
import com.casestudy.service.facility.IFacilityTypeService;
import com.casestudy.service.facility.IRentTypeService;
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


@RequestMapping("/facility")
@Controller
public class FacilityController {
    @Autowired
    private IFacilityService facilityService;


    @Autowired
    private IFacilityTypeService facilityTypeService;


    @Autowired
    private IRentTypeService rentTypeService;


    @GetMapping("")
    public String showList(@PageableDefault(page = 0, size = 5) Pageable pageable,
                           Model model,
                           @RequestParam( required = false, defaultValue = "") String name,
                           @RequestParam( required = false, defaultValue = "") String facilityType) {

        Page<Facility> facilityPage =facilityService.searchFacility(name,facilityType,pageable);
        model.addAttribute("facilityTypeList", facilityTypeService.findAll());
        model.addAttribute("facilityPage",facilityPage);
        model.addAttribute("name",name);
        model.addAttribute("facilityType",facilityType);
        return "facility/list";
    }

    @GetMapping("create")
    public  String create(Model model) {
        model.addAttribute("facilityTypeList",facilityTypeService.findAll());
        model.addAttribute("rentTypeList",rentTypeService.findAll());
        model.addAttribute("facility", new Facility());
        return "/facility/create";
    }

    @PostMapping("save")
    public String save(@Validated @ModelAttribute("facility") FacilityDTO facilityDTO,
                       BindingResult bindingResult, RedirectAttributes redirectAttributes,
                       Model model){
        model.addAttribute("facilityTypeList",facilityTypeService.findAll());
        model.addAttribute("rentTypeList",rentTypeService.findAll());
        if (bindingResult.hasErrors()){
            return "/facility/create";
        }

        Facility facility= new Facility();

        BeanUtils.copyProperties(facilityDTO,facility);
        facilityService.save(facility);
        redirectAttributes.addFlashAttribute("message","Create new facility SussesFully");
        return "redirect:/facility";
    }

    @GetMapping("/edit")
    public  String editCustomer(@RequestParam Long id, Model model) {
        model.addAttribute("facilityTypeList",facilityTypeService.findAll());
        model.addAttribute("rentTypeList",rentTypeService.findAll());
        model.addAttribute("facility",facilityService.findByTd(id));
        return "/facility/edit";
    }

    @PostMapping("/update")
    public String update(@Validated @ModelAttribute("facility") FacilityDTO facilityDTO,
                         BindingResult bindingResult, RedirectAttributes redirectAttributes,
                         Model model){
        model.addAttribute("facilityTypeList",facilityTypeService.findAll());
        model.addAttribute("rentTypeList",rentTypeService.findAll());
        if (bindingResult.hasErrors()){
            return "/facility/edit";
        }

        Facility facility= new Facility();

        BeanUtils.copyProperties(facilityDTO,facility);
        facilityService.save(facility);
        redirectAttributes.addFlashAttribute("message","Edit SussesFully");
        return "redirect:/facility";
    }


    @GetMapping("/delete")
    public String delete(@RequestParam("deleteById") Long deleteById ){
        facilityService.remove(deleteById);
        return "redirect:/facility";
    }
}
