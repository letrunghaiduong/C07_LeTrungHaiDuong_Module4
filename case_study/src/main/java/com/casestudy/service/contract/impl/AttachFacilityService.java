package com.casestudy.service.contract.impl;

import com.casestudy.dto.IAttachFacilityDTO;
import com.casestudy.model.contract.AttachFacility;
import com.casestudy.repository.contract.IAttachFacilityRepository;
import com.casestudy.service.contract.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachFacilityService implements IAttachFacilityService {
    @Autowired
    private IAttachFacilityRepository attachFacilityRepository;

    @Override
    public List<AttachFacility> findAll() {
        return attachFacilityRepository.findAll();
    }

    @Override
    public void save(AttachFacility attachFacility) {
        attachFacilityRepository.save(attachFacility);
    }

    @Override
    public List<IAttachFacilityDTO> attachFacilityList(String id) {
        return attachFacilityRepository.attachFacilityList(id);
    }
}
