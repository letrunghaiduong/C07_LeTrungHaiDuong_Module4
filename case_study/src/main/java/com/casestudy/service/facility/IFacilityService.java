package com.casestudy.service.facility;

import com.casestudy.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IFacilityService {
    Page<Facility> findAll(Pageable pageable);
    Optional<Facility> findByTd(Long id);
    void save(Facility facility);
    void remove(Long id);
    Page<Facility> searchFacility(@Param("name") String name, @Param("facilityType") String facilityType, Pageable pageable);

}
