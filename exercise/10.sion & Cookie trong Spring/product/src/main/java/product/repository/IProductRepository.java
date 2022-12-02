package product.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import product.model.Product;

@Repository
public interface IProductRepository extends PagingAndSortingRepository<Product, Long> {
}