package com.casestudy.repository.facility;

import com.casestudy.model.facility.FacilityType;
import com.casestudy.service.facility.impl.FacilityTypeService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacilityTypeRepository extends JpaRepository<FacilityType,Long> {
}
