package casestudy.service.impl.facility;

import casestudy.model.facility.Facility;
import casestudy.repository.facility.FacilityRepository;
import casestudy.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    FacilityRepository facilityRepository;
    @Override
    public List<Facility> findListAll() {
        return facilityRepository.findAll();
    }

    @Override
    public Page<Facility> fildPageAll(Pageable pageable, String name, String facilityTypeID) {
        return facilityRepository.findPageSearchAll(pageable,name,facilityTypeID);
    }

    @Override
    public void save(Facility facility) {
        facilityRepository.save(facility);
    }
}
