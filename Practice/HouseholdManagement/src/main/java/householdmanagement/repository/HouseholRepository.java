package householdmanagement.repository;

import householdmanagement.dtoView.HouseholView;
import householdmanagement.model.Househol;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HouseholRepository extends JpaRepository<Househol,Integer> {

//    tìm kím theo jion bảng
    @Query(value = "SELECT h.id_househol as idHousehol,\n" +
            "m.name as nameMember,\n" +
            "h.number_member as numberMember,\n" +
            "h.start_day as startDay,\n" +
            "h.address as address\n" +
            "FROM member m \n" +
            "JOIN\n" +
            "househol h \n" +
            "ON h.id_househol = m.househol_id\n" +
            "where m.member_type_id = 1",
            nativeQuery = true,
            countQuery = "select * from (SELECT h.id_househol as idHousehol,\n" +
                    "m.name as nameMember,\n" +
                    "h.number_member as numberMember,\n" +
                    "h.start_day as startDay,\n" +
                    "h.address as address\n" +
                    "FROM member m \n" +
                    "JOIN\n" +
                    "househol h \n" +
                    "ON h.id_househol = m.househol_id\n" +
                    "where m.member_type_id = 1)as A")
    Page<HouseholView> showPage( Pageable pageable);

//    hien thi thanh vien
    @Query(value = "   SELECT * FROM member\n" +
            "   where househol_id  like %:householId%", nativeQuery = true)
    Integer count(@Param("householId") String householId);

}
