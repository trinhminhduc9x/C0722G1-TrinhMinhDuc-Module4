package com.spring_boot.service.impl;

import com.spring_boot.model.Blog;
import com.spring_boot.repository.IBlogRepository;
import com.spring_boot.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository repository;

    @Override
    public List<Blog> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Blog blog) {
        repository.save(blog);
    }

    @Override
    public Optional<Blog> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public void update(Blog blog) {
        repository.save(blog);
    }

    @Override
    public void remove(int id) {
        repository.deleteById(id);
    }

}