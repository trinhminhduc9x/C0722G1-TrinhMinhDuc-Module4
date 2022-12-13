package casestudy.service.contract;

import casestudy.model.contract.AttachFacility;
import casestudy.model.contract.Contract;
import casestudy.model.contract.ContractDetail;
import casestudy.model.customer.Customer;
import casestudy.model.customer.CustomerType;

import java.util.List;

public interface IContractDetailService {
    List<ContractDetail> findListAll();

    ContractDetail findById(Integer id);

    List<AttachFacility> findListattachFacilityByContractId(Integer id);

    void save(ContractDetail contractDetail);
}
