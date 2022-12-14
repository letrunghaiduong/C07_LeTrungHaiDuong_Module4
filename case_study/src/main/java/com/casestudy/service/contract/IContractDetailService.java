package com.casestudy.service.contract;

import com.casestudy.model.contract.Contract;
import com.casestudy.model.contract.ContractDetail;

import java.util.List;

public interface IContractDetailService {
    List<ContractDetail> findAll();
    void save(ContractDetail contractDetail);
}
