package com.casestudy.repository.customer;

import com.casestudy.model.customer.Customer;
import dto.ICustomerDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
    @Query(value = "select c.id , c.name, c.gender,c.address, c.customer_type_id from customer as c where c.check_delete = false",
    nativeQuery = true,
    countQuery = "select c.id , c.name, c.gender,c.address, c.customer_type_id from customer as c where c.check_delete = false")
    Page<ICustomerDTO> finAllCustomer(Pageable pageable);

    @Query(value = "select c.id, c.customer_type_id as customerTypeId, c.name ,c.date_of_birth as dateOfBirth,c.phone_number as phoneNumber,c.email,c.gender from customer as c where (c.name like concat('%',:name,'%') or c.email like concat('%',:email,'%') or c.customer_type_id like concat ('%',:customerTypeId,'%') )"
            , countQuery = "select c.id, c.customer_type_id as customerTypeId, c.name ,c.date_of_birth as dateOfBirth,c.phone_number as phoneNumber,c.email,c.gender from customer as c where  (  c.name like concat('%',:name,'%') or c.email like concat('%',:email,'%') or c.customer_type_id like concat ('%',:customerTypeId,'%'))"
            , nativeQuery = true)
    Page<ICustomerDTO> searchCustomer(@Param("name") String name, @Param("email") String email, @Param("customerTypeId") String customerTypeId, Pageable pageable);
}
