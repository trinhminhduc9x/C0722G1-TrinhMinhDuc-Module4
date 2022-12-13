package casestudy.service.impl.contract;

import casestudy.model.contract.AttachFacility;
import casestudy.model.contract.Contract;
import casestudy.model.contract.ContractDetail;
import casestudy.repository.contract.ContractDetailRepository;
import casestudy.service.contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    ContractDetailRepository contractDetailRepository;


    @Override
    public List<ContractDetail> findListAll() {
        return contractDetailRepository.findAll();
    }

    @Override
    public ContractDetail findById(Integer id) {
        return contractDetailRepository.findById(id).orElse(new ContractDetail());
    }

    @Override
    public List<AttachFacility> findListattachFacilityByContractId(Integer id) {
        List<AttachFacility> attachFacilityList = new ArrayList<>();
        List<ContractDetail> contractDetailList = contractDetailRepository.findAll();

        for (ContractDetail iteam : contractDetailList) {
            if (iteam.getContract().getId_contract()==id){
                attachFacilityList.add(iteam.getAttachFacility());
            }
        }
        return attachFacilityList;
    }

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }
}
