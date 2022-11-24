package vn.codegym.service;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();


    void save(Student student);
}
