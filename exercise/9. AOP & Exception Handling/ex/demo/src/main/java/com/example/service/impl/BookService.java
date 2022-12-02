package com.example.service.impl;

import com.example.model.Book;
import com.example.model.OrderacsAndPayacs;
import com.example.repository.IBookRepository;
import com.example.repository.OrandPayecr;
import com.example.service.IBookService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository repository;
    @Autowired
    private OrandPayecr orandPayecr;


    @Override
    public Iterable<Book> findAll() {
        return null;
    }

    @Override
    public Book findById(Integer id) {
        return repository.findById(id).orElse(new Book());
    }


    @Override
    public void save(Book book) {
        repository.save(book);
    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public List<Book> findListAll() {
        return repository.findAll();
    }

    @Override
    public Page<Book> findPageAll(Pageable pageable, String name) {
        return repository.findAllByName(pageable, name);
    }

    @Override
    public void oandP(Book book, OrderacsAndPayacs orderacsAndPayacs) {
        if ((orderacsAndPayacs.getPayasc() + orderacsAndPayacs.getOrderasc() == book.getAmount()) && orderacsAndPayacs.getOrderasc() < book.getAmount()) {
            Integer oder = book.getOrdersssAndPaysss().getOrderasc() + 1;
            Integer pay = book.getOrdersssAndPaysss().getPayasc() - 1;
            orderacsAndPayacs.setOrderasc(oder);
            orderacsAndPayacs.setPayasc(pay);
            orandPayecr.save(orderacsAndPayacs);
        } else if (orderacsAndPayacs.getPayasc() + orderacsAndPayacs.getOrderasc() < book.getAmount()) {
            Integer oder = book.getOrdersssAndPaysss().getOrderasc() + 1;
            orderacsAndPayacs.setOrderasc(oder);
            orandPayecr.save(orderacsAndPayacs);
        }
    }

    @Override
    public void pay(Book book, OrderacsAndPayacs orderacsAndPayacs,Integer passBook, Integer id) {
        if (passBook == orderacsAndPayacs.getPassBook()) {
            Integer pay = book.getOrdersssAndPaysss().getPayasc() + 1;
            orderacsAndPayacs.setPayasc(pay);
            Integer oder = book.getOrdersssAndPaysss().getOrderasc() - 1;
            orderacsAndPayacs.setOrderasc(oder);
            orandPayecr.save(orderacsAndPayacs);
        }
    }
}