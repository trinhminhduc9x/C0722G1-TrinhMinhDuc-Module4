package casestudy.service.impl.contract;

import casestudy.model.contract.AttachFacility;
import casestudy.repository.contract.AttachFacilityRepository;
import casestudy.service.contract.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AttachFacilityService implements IAttachFacilityService {
    @Autowired
    AttachFacilityRepository attachFacilityRepository;
    @Override
    public List<AttachFacility> findListAll() {
        return attachFacilityRepository.findAll();
    }

    @Override
    public void save(AttachFacility attachFacility) {
        attachFacilityRepository.save(attachFacility);
    }
}
