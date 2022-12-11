package casestudy.repository.facility;

import casestudy.model.facility.RentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentTypeRepository extends JpaRepository<RentType,Integer> {
}
