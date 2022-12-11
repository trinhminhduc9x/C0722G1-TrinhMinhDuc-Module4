package casestudy.repository.facility;

import casestudy.model.facility.FacilityType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacilityTypeRepository extends JpaRepository<FacilityType,Integer> {
}
