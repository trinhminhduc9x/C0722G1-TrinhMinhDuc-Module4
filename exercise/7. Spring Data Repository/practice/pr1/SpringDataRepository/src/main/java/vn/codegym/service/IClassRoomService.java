package vn.codegym.service;

import vn.codegym.model.ClassRoom;


import java.util.List;

public interface IClassRoomService {
    List<ClassRoom> findAll();

    void save(ClassRoom classRoom);

    List<ClassRoom> findByName(String keyword);
}
