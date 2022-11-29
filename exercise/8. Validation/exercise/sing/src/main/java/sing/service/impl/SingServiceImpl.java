package sing.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sing.model.Sing;
import sing.repository.ISingRepository;
import sing.service.ISingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class SingServiceImpl implements ISingService {

    @Autowired
    private ISingRepository repository;


    @Override
    public Sing findById(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Sing> findAll() {
        return repository.findAll();
    }

    @Override
    public void update(Sing sing) {
        repository.save(sing);
    }

    @Override
    public void save(Sing sing) {
        repository.save(sing);
    }

    @Override
    public void remove(Integer id) {
        repository.deleteById(id);
    }
}
