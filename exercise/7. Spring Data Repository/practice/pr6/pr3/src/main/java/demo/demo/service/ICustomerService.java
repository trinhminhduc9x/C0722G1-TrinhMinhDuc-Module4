package demo.demo.service;

import demo.demo.model.Customer;
import demo.demo.model.Province;

import java.util.Optional;

public interface ICustomerService  {
    Iterable<Customer> findAll();

    Optional<Customer> findById(Long id);

    void save(Customer customer);

    void remove(Long id);

    Iterable<Customer> findAllByProvince(Province province);
}
