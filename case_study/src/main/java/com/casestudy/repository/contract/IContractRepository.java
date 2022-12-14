package com.casestudy.repository.contract;

import com.casestudy.dto.IContractDTO;
import com.casestudy.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IContractRepository extends JpaRepository<Contract,Long> {
    @Query(value="SELECT e.name as nameEmployee, c.id, c.start_date as startDate, c.end_date as endDate, c.deposit, cus.name as nameCustomer,f.name as nameFacility, " +
            "(sum(ifnull(cd.quantity, 0) * ifnull(af.cost, 0)) + f.cost) AS totalValue\n" +
            "FROM contract c\n" +
            "    LEFT JOIN contract_detail cd ON c.id = cd.contract_id\n" +
            "    LEFT JOIN attach_facility af ON cd.attach_facility_id = af.id\n" +
            "    LEFT JOIN facility f ON c.facility_id = f.id\n" +
            "    left join customer as cus on c.customer_id = cus.id\n" +
            "    left join employee as e on c.employee_id = e.id\n" +
            "    GROUP BY c.id\n" +
            "    ORDER BY c.id",
    countQuery="SELECT e.name as nameEmployee, c.id, c.start_date as startDate, c.end_date as endDate, c.deposit, cus.name as nameCustomer,f.name as nameFacility, " +
            "(sum(ifnull(cd.quantity, 0) * ifnull(af.cost, 0)) + f.cost) AS totalValue\n" +
            "FROM contract c\n" +
            "    LEFT JOIN contract_detail cd ON c.id = cd.contract_id\n" +
            "    LEFT JOIN attach_facility af ON cd.attach_facility_id = af.id\n" +
            "    LEFT JOIN facility f ON c.facility_id = f.id\n" +
            "    left join customer as cus on c.customer_id = cus.id\n" +
            "    left join employee as e on c.employee_id = e.id\n" +
            "    GROUP BY c.id\n" +
            "    ORDER BY c.id",
            nativeQuery = true)
    Page<IContractDTO> contractList(Pageable pageable);

}
