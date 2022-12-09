package com.casestudy.model.contract;

import javax.persistence.*;

@Entity
@Table(name = "contract_detail")
public class ContractDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "attach_facility_id",referencedColumnName = "id")
    private AttachFacility attachFacility;

    @ManyToOne
    @JoinColumn(name = "contract_id",referencedColumnName = "id")
    private Contract contract;

    private int quantity;
}