package com.example.room_for_rental_children.model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class PeopleHouseHold {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String nameWife;

    @OneToMany(mappedBy = "peopleHouseHold",cascade = CascadeType.REMOVE)
//    @JsonBackReference
    private List<ChildHouseHold> childHouseHoldList;

    @OneToMany(mappedBy = "peopleHouseHold",cascade = CascadeType.REMOVE)
    @JsonBackReference
    private List<MotelRoom> motelRoomList;

    public PeopleHouseHold() {
    }

    public PeopleHouseHold(Integer id, String name, String nameWife, List<ChildHouseHold> childHouseHoldList, List<MotelRoom> motelRoomList) {
        this.id = id;
        this.name = name;
        this.nameWife = nameWife;
        this.childHouseHoldList = childHouseHoldList;
        this.motelRoomList = motelRoomList;
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

    public String getNameWife() {
        return nameWife;
    }

    public void setNameWife(String nameWife) {
        this.nameWife = nameWife;
    }

    public List<ChildHouseHold> getChildHouseHoldList() {
        return childHouseHoldList;
    }

    public void setChildHouseHoldList(List<ChildHouseHold> childHouseHoldList) {
        this.childHouseHoldList = childHouseHoldList;
    }

    public List<MotelRoom> getMotelRoomList() {
        return motelRoomList;
    }

    public void setMotelRoomList(List<MotelRoom> motelRoomList) {
        this.motelRoomList = motelRoomList;
    }
}
