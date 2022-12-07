package com.example.room_for_rental_children.controller;

import com.example.room_for_rental_children.model.ChildHouseHold;
import com.example.room_for_rental_children.model.PeopleHouseHold;
import com.example.room_for_rental_children.service.impl.ChildService;
import com.example.room_for_rental_children.service.impl.PeopleHouseHoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/people")
public class RestPeopleController {
    @Autowired
    ChildService childService;
    @Autowired
    PeopleHouseHoldService peopleHouseHoldService;

    @GetMapping("")
    public ResponseEntity<List<PeopleHouseHold>> showListPeople() {
        List<PeopleHouseHold> peopleHouseHoldList = peopleHouseHoldService.FindListAll();
        if (peopleHouseHoldList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(peopleHouseHoldList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeopleHouseHold> goDetail(@PathVariable Integer id) {
        PeopleHouseHold peopleHouseHold = peopleHouseHoldService.FindById(id);
        if (peopleHouseHold == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(peopleHouseHold, HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity create(@PathVariable Integer id,@RequestBody ChildHouseHold childHouseHold) {
        childHouseHold.setPeopleHouseHold(peopleHouseHoldService.FindById(id));
        childService.save(childHouseHold);
        if (childHouseHold == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(childHouseHold, HttpStatus.CREATED);
    }
}
