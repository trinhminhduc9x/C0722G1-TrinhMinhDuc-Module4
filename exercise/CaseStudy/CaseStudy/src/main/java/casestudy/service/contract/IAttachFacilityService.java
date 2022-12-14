package casestudy.service.contract;

import casestudy.model.contract.AttachFacility;
import casestudy.model.customer.Customer;

import java.util.List;

public interface IAttachFacilityService {
    List<AttachFacility> findListAll();

    void save(AttachFacility attachFacility);
}
