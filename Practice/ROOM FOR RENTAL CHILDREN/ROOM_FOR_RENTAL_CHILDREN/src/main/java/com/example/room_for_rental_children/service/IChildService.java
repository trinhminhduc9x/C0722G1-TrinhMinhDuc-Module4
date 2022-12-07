package com.example.room_for_rental_children.service;

import com.example.room_for_rental_children.model.ChildHouseHold;

import java.util.List;

public interface IChildService {
    List<ChildHouseHold>FindListAll();
    void save(ChildHouseHold childHouseHold);
}
