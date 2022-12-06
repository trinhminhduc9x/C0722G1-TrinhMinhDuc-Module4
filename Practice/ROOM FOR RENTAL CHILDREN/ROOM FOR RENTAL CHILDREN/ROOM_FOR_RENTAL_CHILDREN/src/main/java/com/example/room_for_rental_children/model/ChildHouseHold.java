package com.example.room_for_rental_children.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.*;

@Entity
public class ChildHouseHold {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToOne()
    @JoinColumn(name = "people_HouseHold",referencedColumnName = "id")
    @JsonBackReference
    private PeopleHouseHold peopleHouseHold;


    public ChildHouseHold() {
    }

    public ChildHouseHold(Integer id, String name, PeopleHouseHold peopleHouseHold) {
        this.id = id;
        this.name = name;
        this.peopleHouseHold = peopleHouseHold;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PeopleHouseHold getPeopleHouseHold() {
        return peopleHouseHold;
    }

    public void setPeopleHouseHold(PeopleHouseHold peopleHouseHold) {
        this.peopleHouseHold = peopleHouseHold;
    }
}
