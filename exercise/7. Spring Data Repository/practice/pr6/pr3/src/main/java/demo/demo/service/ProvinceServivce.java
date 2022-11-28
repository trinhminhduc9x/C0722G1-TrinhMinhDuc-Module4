package demo.demo.service;


import demo.demo.model.Province;
import demo.demo.repository.IProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProvinceServivce implements IProvinceService {
    @Autowired
    private IProvinceRepository repository;


    @Override
    public Iterable<Province> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Province> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Province province) {
        repository.save(province);
    }

    @Override
    public void remove(Long id) {
        repository.deleteById(id);
    }
}
