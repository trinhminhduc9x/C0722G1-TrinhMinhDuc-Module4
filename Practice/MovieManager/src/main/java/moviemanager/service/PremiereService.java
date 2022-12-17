package moviemanager.service;

import lombok.Setter;
import moviemanager.model.Premiere;
import moviemanager.repository.PremiereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;




@Service
public class PremiereService implements IPremiereService{

    @Autowired
    PremiereRepository premiereRepository;


    @Override
    public Page<Premiere> fildPage(Pageable pageable) {
        return premiereRepository.findAll(pageable);
    }

    @Override
    public void remove(Integer id) {
        premiereRepository.deleteById(id);
    }


}
