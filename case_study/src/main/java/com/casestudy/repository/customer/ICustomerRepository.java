package com.casestudy.repository.customer;

import com.casestudy.model.customer.Customer;
import dto.ICustomerDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
    @Query(value = "select c.id , c.name, c.gender,c.address, c.customer_type_id from customer as c",
    nativeQuery = true,
    countQuery = "select c.id , c.name, c.gender,c.address, c.customer_type_id from customer as c")
    Page<ICustomerDTO> finAllCustomer(Pageable pageable);
}
