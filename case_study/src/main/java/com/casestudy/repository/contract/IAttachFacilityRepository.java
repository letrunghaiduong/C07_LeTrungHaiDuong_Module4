package com.casestudy.repository.contract;

import com.casestudy.dto.IAttachFacilityDTO;
import com.casestudy.model.contract.AttachFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAttachFacilityRepository extends JpaRepository<AttachFacility,Long> {
    @Query(value="select con.id as contractId , a.name as attachFacilityName, a.status,a.unit,cd.quantity from contract as con join contract_detail cd on con.id = cd.contract_id join attach_facility a on cd.attach_facility_id = a.id where contract_id=:contractId",
    countQuery="select con.id as contractId , a.name as attachFacilityName, a.status,a.unit,cd.quantity from contract as con join contract_detail cd on con.id = cd.contract_id join attach_facility a on cd.attach_facility_id = a.id where contract_id=:contractId",
            nativeQuery = true)
    List<IAttachFacilityDTO> attachFacilityList(@Param("contractId") String contractId);
}
