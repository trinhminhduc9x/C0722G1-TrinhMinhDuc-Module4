package vn.codegym.service;

import vn.codegym.model.Product;
import vn.codegym.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository repository;

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Product product) {
        repository.save(product);
    }

    @Override
    public Product findById(int id) {
       return repository.findById(id);
    }


    @Override
    public void update(Product product) {
        repository.update(product);
    }

    @Override
    public void remove(int id) {
        repository.remove(id);
    }


}