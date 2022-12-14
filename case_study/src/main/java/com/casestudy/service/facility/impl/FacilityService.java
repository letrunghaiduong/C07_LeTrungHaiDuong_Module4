package com.casestudy.service.facility.impl;

import com.casestudy.model.facility.Facility;
import com.casestudy.repository.facility.IFacilityRepository;
import com.casestudy.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class FacilityService implements IFacilityService {
    @Autowired
    private IFacilityRepository facilityRepository;

    @Override
    public Page<Facility> findAll(Pageable pageable) {
        return facilityRepository.findAll(pageable);
    }

    @Override
    public List<Facility> findAll() {
        return facilityRepository.findAll();
    }


    @Override
    public Optional<Facility> findByTd(Long id) {
        return facilityRepository.findById(id);
    }

    @Override
    public void save(Facility facility) {
        facilityRepository.save(facility);
    }

    @Override
    public void remove(Long id) {
        facilityRepository.deleteById(id);
    }

    @Override
    public Page<Facility> searchFacility(String name, String facilityType, Pageable pageable) {
        return facilityRepository.searchFacility(name,facilityType,pageable);
    }
}
