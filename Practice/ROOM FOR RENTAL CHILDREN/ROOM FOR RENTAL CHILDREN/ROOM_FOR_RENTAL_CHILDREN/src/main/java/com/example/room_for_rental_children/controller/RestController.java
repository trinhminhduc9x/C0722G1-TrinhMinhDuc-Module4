package com.example.room_for_rental_children.controller;

import com.example.room_for_rental_children.model.ChildHouseHold;
import com.example.room_for_rental_children.model.PeopleHouseHold;
import com.example.room_for_rental_children.service.impl.ChildService;
import com.example.room_for_rental_children.service.impl.PeopleHouseHoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@CrossOrigin("*")
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {
    @Autowired
    ChildService childService;
    @Autowired
    PeopleHouseHoldService peopleHouseHoldService;

    @GetMapping("/listChild")
    public ResponseEntity<List<ChildHouseHold>> showListChild() {
        List<ChildHouseHold> childHouseHoldList = childService.FindListAll();
        if (childHouseHoldList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(childHouseHoldList, HttpStatus.OK);
    }
    @GetMapping("/listPeople")
    public ResponseEntity<List<PeopleHouseHold>> showListPeople() {
        List<PeopleHouseHold> peopleHouseHoldList = peopleHouseHoldService.FindListAll();
        if (peopleHouseHoldList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(peopleHouseHoldList, HttpStatus.OK);
    }
    @GetMapping("/listPeopleViewId/{id}")
    public ResponseEntity<PeopleHouseHold> goDetail(@PathVariable Integer id) {
        PeopleHouseHold peopleHouseHold = peopleHouseHoldService.FindById(id);
        if (peopleHouseHold == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(peopleHouseHold, HttpStatus.OK);
    }
}
