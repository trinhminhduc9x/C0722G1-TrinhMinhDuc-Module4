package demo.demo.service;


import demo.demo.model.Province;
import demo.demo.repository.IProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProvinceServivce implements IProvinceService {
    @Autowired
    private IProvinceRepository repository;


    @Override
    public List<Province> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Province province) {
        repository.save(province);
    }

    @Override
    public List<Province> findByName(String keyword) {
        return null;
    }

    @Override
    public Optional<Province> findById(int id) {
        return repository.findById(id);
    }

}
