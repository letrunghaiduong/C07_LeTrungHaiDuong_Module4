package com.casestudy.repository.facility;

import com.casestudy.model.customer.Customer;
import com.casestudy.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IFacilityRepository extends JpaRepository<Facility,Long> {
    @Query(value = "select * from facility as f where  (f.name like concat('%',:name,'%') and f.facility_type_id like concat('%',:facilityType,'%'))"
            , countQuery = "select * from facility as f where  (f.name like concat('%',:name,'%') and f.facility_type_id like concat('%',:facilityType,'%'))"
            , nativeQuery = true)
    Page<Facility> searchFacility(@Param("name") String name, @Param("facilityType") String facilityType, Pageable pageable);
}
