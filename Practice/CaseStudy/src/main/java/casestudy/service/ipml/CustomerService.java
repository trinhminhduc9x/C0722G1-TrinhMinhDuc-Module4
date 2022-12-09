package casestudy.service.ipml;

import casestudy.model.customer.Customer;
import casestudy.repository.customer.CustomerRepository;
import casestudy.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    CustomerRepository customerRepository;


    @Override
    public Page<Customer> fildPageAll(Pageable pageable, String name, String dataOfBirth, String address) {
        return customerRepository.findPageSearchAll(pageable,name,dataOfBirth,address);
    }
}
