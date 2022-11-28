package vn.codegym.service;

import vn.codegym.model.ClassRoom;
import vn.codegym.model.Course;

import java.util.List;

public interface ICourseService {
    List<Course> findAll();

    void save(Course course);
}
