package sing.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sing.model.Sing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISingRepository extends JpaRepository<Sing,Integer> {
    @Query(value = " select * from blog where name like :name  ", nativeQuery = true)
    Page<Sing> findAllByName(Pageable pageable, @Param("name") String name);

}
