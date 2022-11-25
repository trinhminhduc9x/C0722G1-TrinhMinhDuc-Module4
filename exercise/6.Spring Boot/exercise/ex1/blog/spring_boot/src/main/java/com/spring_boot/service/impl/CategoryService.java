package com.spring_boot.service.impl;

import com.spring_boot.model.Category;
import com.spring_boot.repository.ICategoryRrpository;
import com.spring_boot.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRrpository repository;

    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Category category) {
        repository.save(category);
    }

    @Override
    public Optional<Category> findById(int id) {
        return Optional.empty();
    }

    @Override
    public void update(Category category) {

    }

    @Override
    public void remove(int id) {

    }
}
