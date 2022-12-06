package com.example.room_for_rental_children.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class PayMony {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer payMony;

    @OneToMany(mappedBy = "payMony",cascade = CascadeType.REMOVE)
    private List<MotelRoom>motelRoomList;

    public PayMony() {
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

    public Integer getPayMony() {
        return payMony;
    }

    public void setPayMony(Integer payMony) {
        this.payMony = payMony;
    }

    public List<MotelRoom> getMotelRoomList() {
        return motelRoomList;
    }

    public void setMotelRoomList(List<MotelRoom> motelRoomList) {
        this.motelRoomList = motelRoomList;
    }
}
