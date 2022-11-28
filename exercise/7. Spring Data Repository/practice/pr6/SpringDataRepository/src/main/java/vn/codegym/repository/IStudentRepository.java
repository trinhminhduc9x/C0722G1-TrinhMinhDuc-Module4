package vn.codegym.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.codegym.model.Student;

import java.util.List;

public interface IStudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByName(String keyword);

    List<Student> findByNameContaining(String keyword);

    /*Tìm theo tên tương đối và ID lớn hơn 2*/

    List<Student> findByNameContainingAndIdGreaterThan(String keyword, int id);

    @Query(value = "select * from Student where name =:keyword", nativeQuery = true)
    Page<Student> findList(@Param("keyword") String keyword, Pageable pageable);


}
