package casestudy.service.customer;

import casestudy.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    Page<Customer> fildPageAll(Pageable pageable, String name, String dataOfBirth, String CustomerTypeID);
    void save(Customer customer);
    List<Customer> findListAll();

    Customer findById(Integer id);

    void remove(Integer id);
}
