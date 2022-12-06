package com.example.room_for_rental_children.model;

import javax.persistence.*;


@Entity
public class MotelRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne()
    @JoinColumn(name = "people_HouseHold", referencedColumnName = "id")
    private PeopleHouseHold peopleHouseHold;
    private String phoneNumber;
    @Column(columnDefinition = "DATE")
    private String dateStart;
    @Column(columnDefinition = "DATE")
    private String dateEnd;
    @ManyToOne
    @JoinColumn(name = "pay_Many", referencedColumnName = "id")
    private PayMony payMony;

    private String note;

    public MotelRoom() {
    }

    public MotelRoom(Integer id, PeopleHouseHold peopleHouseHold, String phoneNumber, String dateStart, String dateEnd, PayMony payMony, String note) {
        this.id = id;
        this.peopleHouseHold = peopleHouseHold;
        this.phoneNumber = phoneNumber;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.payMony = payMony;
        this.note = note;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PeopleHouseHold getPeopleHouseHold() {
        return peopleHouseHold;
    }

    public void setPeopleHouseHold(PeopleHouseHold peopleHouseHold) {
        this.peopleHouseHold = peopleHouseHold;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public PayMony getPayMony() {
        return payMony;
    }

    public void setPayMony(PayMony payMony) {
        this.payMony = payMony;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
