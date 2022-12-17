package householdmanagement.repository;

import householdmanagement.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MenberRepository extends JpaRepository<Member,Integer> {
    @Query(value = " SELECT * FROM member\n" +
            "where member_type_id = 1", nativeQuery = true)
    List<Member> listNameMember();

    @Query(value = " SELECT * FROM member\n" +
            "where househol_id  like %:householId%   ", nativeQuery = true)
    List<Member> listMemberById(@Param("householId") Integer householId);
}
