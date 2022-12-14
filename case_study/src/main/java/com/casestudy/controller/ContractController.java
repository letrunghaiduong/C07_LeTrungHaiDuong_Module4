package com.casestudy.controller;

import com.casestudy.dto.IContractDTO;
import com.casestudy.model.contract.AttachFacility;
import com.casestudy.model.contract.Contract;
import com.casestudy.model.contract.ContractDetail;
import com.casestudy.model.customer.Customer;
import com.casestudy.model.employee.Employee;
import com.casestudy.service.contract.IAttachFacilityService;
import com.casestudy.service.contract.IContractDetailService;
import com.casestudy.service.contract.IContractService;
import com.casestudy.service.customer.ICustomerService;
import com.casestudy.service.employee.IEmployeeService;
import com.casestudy.service.facility.IFacilityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService contractService;

    @Autowired
    private IAttachFacilityService attachFacilityService;

    @Autowired
    private IContractDetailService contractDetailService;

    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IFacilityService facilityService;


    @GetMapping("")
    public String contractList(@PageableDefault(page = 0,size = 5) Pageable pageable,
                               Model model){
        Page<IContractDTO> contractList =contractService.contractList(pageable);
        List<Employee> employeeList =employeeService.findAll();
//        model.addAttribute("attachFacilities", attachFacilityService.attachFacilityList(contractId));

        model.addAttribute("contract",new Contract());
        model.addAttribute("attachFacility",new AttachFacility());
        model.addAttribute("contractDetail",new ContractDetail());
        model.addAttribute("attachFacilityList", attachFacilityService.findAll());
        model.addAttribute("contractList", contractList);
        model.addAttribute("facilityList", facilityService.findAll());
        model.addAttribute("customerList", customerService.findAll());
        model.addAttribute("employeeList", employeeList);
        return "contract/list";
    }


    @PostMapping("create")
    public String create(@ModelAttribute("contract") Contract contract,RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("message","Create success");
        contractService.save(contract);
        return "redirect:/contract";
    }


    @PostMapping("create-contractDetail")
    public String createContractDetail(@ModelAttribute("contractDetail") ContractDetail contractDetail,RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("message","Create success");
        contractDetailService.save(contractDetail);
        return "redirect:/contract";
    }

}
