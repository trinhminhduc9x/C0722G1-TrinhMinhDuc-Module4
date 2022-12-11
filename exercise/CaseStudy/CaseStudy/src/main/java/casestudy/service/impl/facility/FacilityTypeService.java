package casestudy.service.impl.facility;

import casestudy.model.facility.Facility;
import casestudy.model.facility.FacilityType;
import casestudy.repository.facility.FacilityTypeRepository;
import casestudy.service.facility.IFacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FacilityTypeService implements IFacilityTypeService {
    @Autowired
    FacilityTypeRepository facilityTypeRepository;
    @Override
    public List<FacilityType> findListAll() {
        return facilityTypeRepository.findAll();
    }
}
