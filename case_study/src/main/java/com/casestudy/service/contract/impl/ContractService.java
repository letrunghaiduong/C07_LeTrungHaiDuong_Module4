package com.casestudy.service.contract.impl;

import com.casestudy.dto.IContractDTO;
import com.casestudy.model.contract.Contract;
import com.casestudy.repository.contract.IContractRepository;
import com.casestudy.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository contractRepository;

    @Override
    public Page<IContractDTO> contractList(Pageable pageable) {
        return contractRepository.contractList(pageable);
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }
}
