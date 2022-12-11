package casestudy.service.impl.customer;

import casestudy.model.customer.CustomerType;
import casestudy.repository.customer.CustomerTypeRepository;
import casestudy.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    private CustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> fildListAll() {
        return customerTypeRepository.findAll();
    }
}
