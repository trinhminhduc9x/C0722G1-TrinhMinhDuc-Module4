package casestudy.service.impl.customer;

import casestudy.model.customer.Customer;
import casestudy.repository.customer.CustomerRepository;
import casestudy.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    CustomerRepository customerRepository;


    @Override
    public Page<Customer> fildPageAll(Pageable pageable, String name, String dataOfBirth, String address) {
        return customerRepository.findPageSearchAll(pageable, name, dataOfBirth, address);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public List<Customer> findListAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Integer id) {
        return customerRepository.findById(id).orElse(new Customer());
    }

    @Override
    public void remove(Integer id) {
        customerRepository.deleteById(id);
    }
}
