package casestudy.service;

import casestudy.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Page<Customer> fildPageAll(Pageable pageable, String name, String dataOfBirth, String CustomerTypeID);
}
