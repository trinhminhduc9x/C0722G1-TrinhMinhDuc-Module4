package householdmanagement.service;

import householdmanagement.dtoView.HouseholView;
import householdmanagement.model.Househol;
import householdmanagement.model.Member;
import householdmanagement.repository.HouseholRepository;
import householdmanagement.repository.MenberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.List;


@Service
public class HouseholService implements IHouseholService{
    @Autowired
    HouseholRepository householRepository;

    @Autowired
    MenberRepository menberRepository;
    @Override
    public Page<HouseholView> fildPageAll(Pageable pageable) {

//        đếm số lượng các thành viên và hiển thị ra

//        List<Househol> householList = householRepository.findAll();
//
//        for (Househol s : householList) {
//            s.setNumberMember(String.valueOf(householRepository.count(Integer.toString(s.getIdHousehol()))));
//            householRepository.save(s);
//        }

        return householRepository.showPage(pageable);
    }

    @Override
    public Integer count(String householId) {
        return householRepository.count(householId);
    }

    @Override
    public List<Member> nameMemBer() {
        return menberRepository.listNameMember();
    }

    @Override
    public List<Member> findMemberById(Integer id) {
             return menberRepository.listMemberById(id);
    }

    @Override
    public void save(Househol househol) {
        householRepository.save(househol);
    }

    @Override
    public Househol findById(Integer id) {
        return householRepository.findById(id).orElse(new Househol());
    }


}
