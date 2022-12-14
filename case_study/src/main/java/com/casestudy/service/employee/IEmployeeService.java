package com.casestudy.service.employee;

import com.casestudy.model.contract.AttachFacility;
import com.casestudy.model.employee.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();
}
