package demo.demo.service;

import demo.demo.model.Province;
import demo.demo.model.Province;

import java.util.Optional;

public interface IProvinceService {

    Iterable<Province> findAll();

    Optional<Province> findById(Long id);


    void save(Province province);

    void remove(Long id);

}
