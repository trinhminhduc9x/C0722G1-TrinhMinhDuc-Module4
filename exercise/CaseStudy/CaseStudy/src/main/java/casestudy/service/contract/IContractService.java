package casestudy.service.contract;

import casestudy.model.contract.Contract;
import casestudy.model.contract.ContractDetail;
import casestudy.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService {
    Page<Contract> fildPageAll(Pageable pageable);

    Contract findById(Integer id);
}
