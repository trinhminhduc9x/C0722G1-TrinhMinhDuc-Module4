package householdmanagement.repository;

import householdmanagement.model.MemberType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberTypeRepository extends JpaRepository<MemberType,Integer> {
}
