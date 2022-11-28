package demo.demo.repository;

import demo.demo.model.Customer;
import demo.demo.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    Iterable<Customer> findAllByProvince(Province province);
}