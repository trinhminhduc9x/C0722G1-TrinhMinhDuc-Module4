package com.example.room_for_rental_children.service.impl;

import com.example.room_for_rental_children.model.MotelRoom;
import com.example.room_for_rental_children.repository.MotelRoomRepository;
import com.example.room_for_rental_children.service.IMotelRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MotelRoomService implements IMotelRoomService {
    @Autowired
    MotelRoomRepository motelRoomRepository;
    @Override
    public List<MotelRoom> findListAll() {
        return motelRoomRepository.findAll();
    }

    @Override
    public Page<MotelRoom> findPageAll(Pageable pageable) {
        return motelRoomRepository.findAll(pageable);
    }

    @Override
    public Page<MotelRoom> findPageSearchAll(Pageable pageable, String dateStart, String dateEnd) {
        return motelRoomRepository.findPageSearchAll(pageable,dateStart,dateEnd);
    }

    @Override
    public void remove(Integer id) {
        motelRoomRepository.deleteById(id);
    }
}
