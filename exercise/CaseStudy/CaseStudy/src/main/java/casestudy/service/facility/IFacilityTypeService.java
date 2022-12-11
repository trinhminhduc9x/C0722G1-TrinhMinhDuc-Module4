package casestudy.service.facility;

import casestudy.model.facility.Facility;
import casestudy.model.facility.FacilityType;

import java.util.List;

public interface IFacilityTypeService {
    List<FacilityType> findListAll();
}
