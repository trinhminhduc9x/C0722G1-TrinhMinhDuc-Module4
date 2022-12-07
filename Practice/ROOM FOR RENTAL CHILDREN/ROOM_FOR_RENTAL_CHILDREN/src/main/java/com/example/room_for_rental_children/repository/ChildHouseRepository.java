package com.example.room_for_rental_children.repository;

import com.example.room_for_rental_children.model.ChildHouseHold;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildHouseRepository extends JpaRepository<ChildHouseHold,Integer> {
}
