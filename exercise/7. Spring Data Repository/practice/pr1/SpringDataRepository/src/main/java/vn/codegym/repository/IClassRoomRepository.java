package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.ClassRoom;


public interface IClassRoomRepository extends JpaRepository<ClassRoom, Integer> {
}
