package com.casestudy.service.contract;

import com.casestudy.dto.IContractDTO;
import com.casestudy.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService {
    Page<IContractDTO> contractList(Pageable pageable);

    void save(Contract contract);

}
