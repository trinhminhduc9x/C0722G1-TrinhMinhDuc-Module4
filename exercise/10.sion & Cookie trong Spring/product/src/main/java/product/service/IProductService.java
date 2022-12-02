package product.service;

import product.model.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();
    Optional<Product> findById(Long id);
    Product findByIda (Long id);

}
