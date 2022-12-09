package com.example.room_for_rental_children.service.impl;

import com.example.room_for_rental_children.model.PayMony;
import com.example.room_for_rental_children.repository.PayMonyRepository;
import com.example.room_for_rental_children.service.IPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PayService implements IPayService {
    @Autowired
    PayMonyRepository repository;
    @Override
    public List<PayMony> PAY_MONY_LIST() {
        return repository.findAll();
    }
}
