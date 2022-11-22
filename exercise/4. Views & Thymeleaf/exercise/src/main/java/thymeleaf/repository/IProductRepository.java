package thymeleaf.repository;

import thymeleaf.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void update(int id, Product product);

    void remove(int id);
    public List<Product> findByName(String keyword);
}
