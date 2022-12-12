package casestudy.service.impl.facility;

import casestudy.model.facility.RentType;
import casestudy.repository.facility.RentTypeRepository;
import casestudy.service.facility.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RentTypeService implements IRentTypeService {
    @Autowired
    RentTypeRepository rentTypeRepository;
    @Override
    public List<RentType> fildListAll() {
        return rentTypeRepository.findAll();
    }
}
