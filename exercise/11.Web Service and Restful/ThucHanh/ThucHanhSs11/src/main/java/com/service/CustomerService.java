package com.service;

import com.model.Customer;
import com.repsitory.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository repository;

    @Override
    public Iterable<Customer> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Customer save(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public void remove(Long id) {
        repository.deleteById(id);
    }
}
