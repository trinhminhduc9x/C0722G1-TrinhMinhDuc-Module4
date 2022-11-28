package demo.demo.service;

import demo.demo.model.Customer;
import demo.demo.model.Province;
import demo.demo.model.Province;

import java.util.List;
import java.util.Optional;

public interface IProvinceService {

    List<Province> findAll();

    void save(Province province);

    List<Province> findByName(String keyword);
    Optional<Province> findById(int id);
}
