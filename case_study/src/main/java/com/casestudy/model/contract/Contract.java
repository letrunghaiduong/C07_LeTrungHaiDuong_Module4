package com.casestudy.model.contract;

import com.casestudy.model.customer.Customer;
import com.casestudy.model.employee.Employee;
import com.casestudy.model.facility.Facility;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "contract")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "date")
    private String startDate;

    @Column(columnDefinition = "date")
    private String endDate;

    private double deposit;

    @ManyToOne
    @JoinColumn(name = "customer_id",referencedColumnName = "id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "employee_id",referencedColumnName = "id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "facility_id",referencedColumnName = "id")
    private Facility facility;


}
