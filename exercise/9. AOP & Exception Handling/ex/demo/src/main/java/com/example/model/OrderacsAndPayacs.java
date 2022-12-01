package com.example.model;



import javax.persistence.*;
import java.util.Set;

@Entity
public class OrderacsAndPayacs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Integer passBook;
    private Integer payasc;
    private Integer orderasc;


    @OneToMany(mappedBy = "ordersssAndPaysss",cascade = CascadeType.ALL)
    private Set<Book> books;


    public OrderacsAndPayacs() {
    }

    public OrderacsAndPayacs(int id, Integer passBook, Integer payasc, Integer orderasc, Set<Book> books) {
        this.id = id;
        this.passBook = passBook;
        this.payasc = payasc;
        this.orderasc = orderasc;
        this.books = books;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getPassBook() {
        return passBook;
    }

    public void setPassBook(Integer passBook) {
        this.passBook = passBook;
    }

    public Integer getPayasc() {
        return payasc;
    }

    public void setPayasc(Integer payasc) {
        this.payasc = payasc;
    }

    public Integer getOrderasc() {
        return orderasc;
    }

    public void setOrderasc(Integer orderasc) {
        this.orderasc = orderasc;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
