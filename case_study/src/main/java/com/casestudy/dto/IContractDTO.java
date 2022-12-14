package com.casestudy.dto;

import com.casestudy.model.customer.Customer;
import com.casestudy.model.employee.Employee;
import com.casestudy.model.facility.Facility;

public interface IContractDTO {
    public Long getId();

    public String getStartDate();

    public String getEndDate();

    public double getDeposit();
    public double getTotalValue();
    public String getNameCustomer();

    public String getNameEmployee();


    public String getNameFacility();

}
