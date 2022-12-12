package com.casestudy.service.customer;

import com.casestudy.dto.CustomerDTO;
import com.casestudy.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable);
    void save(Customer customer);
    Optional findById(Integer id);
    void remove(Integer id);
    Page<Customer> searchCustomer(@Param("name") String name, @Param("email") String email, @Param("customerTypeId") String customerTypeId, Pageable pageable);

}
