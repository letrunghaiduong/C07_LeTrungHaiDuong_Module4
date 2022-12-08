package com.casestudy.service.customer;

import com.casestudy.model.customer.Customer;
import dto.ICustomerDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    List<Customer> findAll();
    Page<ICustomerDTO> finAllCustomer(Pageable pageable);
    void save(Customer customer);
    Optional findById(Integer id);
    void remove(Integer id);
}
