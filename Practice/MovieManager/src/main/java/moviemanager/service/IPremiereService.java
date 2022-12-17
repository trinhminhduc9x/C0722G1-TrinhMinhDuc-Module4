package moviemanager.service;

import moviemanager.model.Premiere;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IPremiereService {
    Page<Premiere> fildPage(Pageable pageable);

    void remove(Integer id);
}
