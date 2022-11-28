package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();

    void save(Student student);

//    List<Student> findByName(String keyword);
    Page<Student> finAllGood(String keyword, Pageable pageable);
}
