package com.example.room_for_rental_children.service.impl;

import com.example.room_for_rental_children.model.PeopleHouseHold;
import com.example.room_for_rental_children.repository.PeopleHouseHoldRepostory;
import com.example.room_for_rental_children.service.IPeopleHouseHoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PeopleHouseHoldService implements IPeopleHouseHoldService {
    @Autowired
    PeopleHouseHoldRepostory repostory;
    @Override
    public List<PeopleHouseHold> FindListAll() {
        return repostory.findAll();
    }

    @Override
    public PeopleHouseHold FindById(Integer id) {
        return repostory.findById(id).orElse(new PeopleHouseHold());
    }

    @Override
    public void save(PeopleHouseHold peopleHouseHold) {
        repostory.save(peopleHouseHold);
    }

}
