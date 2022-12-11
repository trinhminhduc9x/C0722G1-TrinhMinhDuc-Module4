package casestudy.repository.facility;

import casestudy.model.customer.Customer;
import casestudy.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FacilityRepository extends JpaRepository<Facility,Integer> {


    @Query(value = " select *  from facility where name like %:name% and facility_type like %:facilityTypeID% ", nativeQuery = true)
    Page<Facility> findPageSearchAll(Pageable pageable, @Param("name") String name,  @Param("facilityTypeID") String facilityTypeID);


}
