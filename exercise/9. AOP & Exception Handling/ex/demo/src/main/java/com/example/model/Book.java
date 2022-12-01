package com.example.model;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Integer amount;
    @ManyToOne()
    @JoinColumn(name = "ordersss_paysss_id", referencedColumnName = "id")
    private OrderacsAndPayacs ordersssAndPaysss;
    public Book() {
    }

    public Book(int id, String name, Integer amount, OrderacsAndPayacs ordersssAndPaysss) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.ordersssAndPaysss = ordersssAndPaysss;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public OrderacsAndPayacs getOrdersssAndPaysss() {
        return ordersssAndPaysss;
    }

    public void setOrdersssAndPaysss(OrderacsAndPayacs ordersssAndPaysss) {
        this.ordersssAndPaysss = ordersssAndPaysss;
    }
}