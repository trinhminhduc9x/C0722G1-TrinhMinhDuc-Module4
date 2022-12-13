package casestudy.service.contract;

import casestudy.model.contract.AttachFacility;
import casestudy.model.contract.Contract;
import casestudy.model.contract.ContractDetail;
import casestudy.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {
    Page<Contract> fildPageAll(Pageable pageable);
    Contract findById(Integer id);

    List<Contract> findListAll();

    void save(Contract contract);
}
