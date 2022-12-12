package casestudy.service.facility;

import casestudy.model.customer.Customer;
import casestudy.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IFacilityService  {
    List<Facility> findListAll();

    Page<Facility> fildPageAll(Pageable pageable, String name, String facilityTypeID);

    void save(Facility facility);


    Facility findById(Integer id);

    void remove(Integer id);
}
