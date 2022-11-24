package com.codegym.service;

import com.codegym.model.Product;

import java.util.*;

public class ProductService implements IProductService {
    private static List<Product> productList;

    static {
        productList = new ArrayList<>();
        productList.add( new Product(1, "a", "1000000", "mau xanh","honda"));
        productList.add( new Product(2, "b", "2000000", "mau xanh","honda"));
        productList.add( new Product(3, "c", "3000000", "mau xanh","honda"));
        productList.add( new Product(4, "d", "4000000", "mau xanh","honda"));
        productList.add( new Product(5, "e", "5000000", "mau xanh","honda"));
        productList.add( new Product(6, "f", "6000000", "mau xanh","honda"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productList);
    }

    @Override
    public void save(Product product) {
        productList.add( product);
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
        for(Product product: productList){
            if(product.getName().contains(keyword)){
                result.add(product);
            }
        }
        return result;
    }
}