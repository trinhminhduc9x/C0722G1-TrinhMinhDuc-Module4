package com.example.service.impl;

import com.example.model.Book;
import com.example.model.OrderacsAndPayacs;
import com.example.repository.IBookRepository;
import com.example.repository.OrandPayecr;
import com.example.service.IOandPservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class OAndPService implements IOandPservice {
    @Autowired
    private OrandPayecr repository;

    @Override
    public List<OrderacsAndPayacs> findListAll() {
        return repository.findAll();
    }

    @Override
    public Iterable<OrderacsAndPayacs> findAll() {
        return null;
    }

    @Override
    public OrderacsAndPayacs findById(Integer id) {
        return repository.findById(id).orElse(new OrderacsAndPayacs());
    }


    @Override
    public void save(OrderacsAndPayacs orderacsAndPayacs) {
        repository.save(orderacsAndPayacs);
    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public Page<OrderacsAndPayacs> findPageAll(Pageable pageable, String name) {
        return null;
    }

    @Override
    public OrderacsAndPayacs ramdom() {
        OrderacsAndPayacs orderacsAndPayacs = new OrderacsAndPayacs();
        Random generator = new Random();
        Integer pass = generator.nextInt((99999 - 0) + 1) + 0;
        orderacsAndPayacs.setPassBook(pass);
        orderacsAndPayacs.setPayasc(0);
        orderacsAndPayacs.setOrderasc(0);
        return orderacsAndPayacs;
    }
}
