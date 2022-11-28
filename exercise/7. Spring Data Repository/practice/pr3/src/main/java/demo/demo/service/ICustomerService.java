package demo.demo.service;

import demo.demo.model.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService  {
    List<Customer> findAll();

    void save(Customer customer);

    List<Customer> findByName(String keyword);

    void remove(int id);

    Optional<Customer> findById(int id);

}
