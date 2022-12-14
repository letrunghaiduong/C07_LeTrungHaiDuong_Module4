package com.casestudy.model.contract;

import javax.persistence.*;

@Entity
public class ContractDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private AttachFacility attachFacility;

    @ManyToOne
    private Contract contract;

    private int quantity;

    public ContractDetail(Long id, AttachFacility attachFacility, Contract contract, int quantity) {
        this.id = id;
        this.attachFacility = attachFacility;
        this.contract = contract;
        this.quantity = quantity;
    }

    public ContractDetail() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AttachFacility getAttachFacility() {
        return attachFacility;
    }

    public void setAttachFacility(AttachFacility attachFacility) {
        this.attachFacility = attachFacility;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}