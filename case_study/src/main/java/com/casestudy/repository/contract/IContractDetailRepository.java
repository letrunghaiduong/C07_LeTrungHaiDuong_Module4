package com.casestudy.repository.contract;

import com.casestudy.model.contract.AttachFacility;
import com.casestudy.model.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractDetailRepository extends JpaRepository<ContractDetail,Long> {
}
