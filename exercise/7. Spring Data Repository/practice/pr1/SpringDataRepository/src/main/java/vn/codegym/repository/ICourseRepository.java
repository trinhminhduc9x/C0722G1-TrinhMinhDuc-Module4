package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.ClassRoom;
import vn.codegym.model.Course;

public interface ICourseRepository extends JpaRepository<Course, Integer> {
}
