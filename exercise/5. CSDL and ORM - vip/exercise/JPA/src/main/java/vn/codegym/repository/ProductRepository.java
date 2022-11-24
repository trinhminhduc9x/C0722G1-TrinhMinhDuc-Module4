package vn.codegym.repository;

import vn.codegym.model.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


@Transactional
@Repository
public class ProductRepository implements IProductRepository {
    @PersistenceContext
    private EntityManager entityManager;

    
    @Override
    public List<Product> findAll() {
        TypedQuery<Product> query = entityManager
                .createQuery("select p from Product as p", Product.class);
        return query.getResultList();
    }

    @Override
    public void save(Product product) {
        entityManager.persist(product); //thêm mới
    }

    @Override
    public Product findById(int id) {
      return  entityManager.find(Product.class, id); //tra ve 1 doi tuong voi id được nhập
    }

    @Override
    public void update( Product product) {
        entityManager.merge(product); //cập nhật

    }

    @Override
    public void remove(int id) {
        Product product = findById(id);
        entityManager.remove(product); //xóa
    }
}