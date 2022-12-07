package com.example.room_for_rental_children.service.impl;

import com.example.room_for_rental_children.model.ChildHouseHold;
import com.example.room_for_rental_children.repository.ChildHouseRepository;
import com.example.room_for_rental_children.service.IChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ChildService implements IChildService {
    @Autowired
    ChildHouseRepository repository;
    @Override
    public List<ChildHouseHold> FindListAll() {
        return repository.findAll();
    }

    @Override
    public void save(ChildHouseHold childHouseHold) {
        repository.save(childHouseHold);
    }
}
