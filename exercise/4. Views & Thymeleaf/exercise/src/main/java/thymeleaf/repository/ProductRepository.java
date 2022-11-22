package thymeleaf.repository;

import org.springframework.stereotype.Repository;
import thymeleaf.model.Product;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository{
    private static List<Product> productList;

    static {
        productList = new ArrayList<>();
        productList.add( new Product(1, "xe may", "1000000", "mau xanh","honda"));
        productList.add( new Product(2, "xe dap", "2000000", "mau do","honda"));
        productList.add( new Product(3, "oto", "3000000", "mau tim","honda"));
        productList.add( new Product(4, "may anh", "4000000", "mau vang","honda"));
        productList.add( new Product(5, "may bay", "5000000", "mau den","honda"));
        productList.add( new Product(6, "xe tai", "6000000", "mau xanh","honda"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productList);
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }

    @Override
    public Product findById(int id) {
        return productList.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productList.add(product);
    }

    @Override
    public void remove(int id) {
        productList.remove(id);
    }

    @Override
    public List<Product> findByName(String keyword) {
        List<Product> result = new ArrayList<>();
        for (Product product : productList) {
            if (product.getName().contains(keyword)) {
                result.add(product);
            }
        }
        return result;
    }
}
