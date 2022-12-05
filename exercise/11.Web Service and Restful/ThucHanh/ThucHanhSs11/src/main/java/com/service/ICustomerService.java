package com.service;

import com.model.Customer;

import java.util.Optional;

public interface ICustomerService extends  IGeneralService<Customer>{

    @Override
    Iterable<Customer> findAll();

    @Override
    Optional<Customer> findById(Long id);

    @Override
    Customer save(Customer customer);

    @Override
    void remove(Long id);
}
