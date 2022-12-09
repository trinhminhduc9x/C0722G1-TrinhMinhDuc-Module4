package com.example.room_for_rental_children.service;


import com.example.room_for_rental_children.model.MotelRoom;
import com.example.room_for_rental_children.model.PeopleHouseHold;

import java.util.List;

public interface IPeopleHouseHoldService {
    List<PeopleHouseHold> FindListAll();
    PeopleHouseHold FindById(Integer id);

    void save(PeopleHouseHold peopleHouseHold);

}
