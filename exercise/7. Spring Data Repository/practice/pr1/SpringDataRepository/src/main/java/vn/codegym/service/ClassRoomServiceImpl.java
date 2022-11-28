package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.ClassRoom;
import vn.codegym.repository.IClassRoomRepository;
import vn.codegym.repository.IStudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ClassRoomServiceImpl implements IClassRoomService{
    @Autowired
    private IClassRoomRepository repository;
    @Override
    public List<ClassRoom> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(ClassRoom classRoom) {
        repository.save(classRoom);
    }

    @Override
    public List<ClassRoom> findByName(String keyword) {

        return null;
    }
}
