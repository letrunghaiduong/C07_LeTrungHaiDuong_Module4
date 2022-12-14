package com.casestudy.service.contract;

import com.casestudy.dto.IAttachFacilityDTO;
import com.casestudy.model.contract.AttachFacility;
import com.casestudy.model.contract.ContractDetail;

import java.util.List;

public interface IAttachFacilityService {
    List<AttachFacility> findAll();
    void save(AttachFacility attachFacility);
    List<IAttachFacilityDTO> attachFacilityList(String id);


}
