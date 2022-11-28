package com.spring_boot.service.impl;

import com.spring_boot.model.Blog;
import com.spring_boot.model.Category;
import com.spring_boot.repository.ICategoryRepository;
import com.spring_boot.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository repository;

    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Category category) {
        repository.save(category);
    }

    @Override
    public Category findById(Integer id) {
        return repository.findById(id).orElse(new Category());
    }

    @Override
    public void update(Category category) {
        repository.save(category);
    }

    @Override
    public void remove(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Page<Category> findAll(Pageable pageable, String name) {
        return this.repository.findAllByName(pageable, "%" + name + "%");
    }
}
