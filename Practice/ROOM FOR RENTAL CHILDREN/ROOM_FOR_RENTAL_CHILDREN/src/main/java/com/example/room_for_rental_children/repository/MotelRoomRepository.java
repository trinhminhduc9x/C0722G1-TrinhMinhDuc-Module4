package com.example.room_for_rental_children.repository;

import com.example.room_for_rental_children.model.MotelRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface MotelRoomRepository extends JpaRepository<MotelRoom,Integer> {
}
