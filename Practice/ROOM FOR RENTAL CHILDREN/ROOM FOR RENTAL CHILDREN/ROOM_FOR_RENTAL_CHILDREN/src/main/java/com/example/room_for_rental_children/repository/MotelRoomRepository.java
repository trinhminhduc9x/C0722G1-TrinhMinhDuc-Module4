package com.example.room_for_rental_children.repository;

import com.example.room_for_rental_children.model.MotelRoom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface MotelRoomRepository extends JpaRepository<MotelRoom,Integer> {
    @Query(value = " select *  from motel_room.motel_room where motel_room.date_start like %:dateStart% and motel_room.date_end like %:dateEnd% ", nativeQuery = true)
    Page<MotelRoom> findPageSearchAll(Pageable pageable, @Param("dateStart") String dateStart, @Param("dateEnd") String dateEnd);
}
