package casestudy.service.impl.contract;

import casestudy.model.contract.Contract;
import casestudy.model.customer.Customer;
import casestudy.repository.contract.ContractRepository;
import casestudy.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {
    @Autowired
    ContractRepository contractRepository;
    @Override
    public Page<Contract> fildPageAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public Contract findById(Integer id) {
        return contractRepository.findById(id).orElse(new Contract());
    }

    @Override
    public List<Contract> findListAll() {
        return contractRepository.findAll();
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }
}
