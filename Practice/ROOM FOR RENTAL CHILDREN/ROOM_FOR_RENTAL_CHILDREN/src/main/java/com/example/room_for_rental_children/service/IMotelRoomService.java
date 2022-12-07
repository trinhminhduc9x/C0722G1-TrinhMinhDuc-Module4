package com.example.room_for_rental_children.service;

import com.example.room_for_rental_children.model.MotelRoom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IMotelRoomService {
    List<MotelRoom> findListAll();
    Page<MotelRoom> findPageAll(Pageable pageable);
    Page<MotelRoom> findPageSearchAll(Pageable pageable, String dateStart,String dateEnd);
    void remove(Integer id);
}
