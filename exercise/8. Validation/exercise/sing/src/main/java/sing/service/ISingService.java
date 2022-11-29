package sing.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sing.model.Sing;

import java.util.List;
import java.util.Optional;

public interface ISingService extends IGeneralService<Sing> {


    Sing findById(Integer id);

    @Override
    List<Sing> findAll();

    @Override
    void update(Sing sing);

    @Override
    void save(Sing sing);

    @Override
    void remove(Integer id);


}
