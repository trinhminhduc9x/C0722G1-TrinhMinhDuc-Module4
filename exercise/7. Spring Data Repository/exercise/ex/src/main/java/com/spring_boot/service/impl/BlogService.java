package com.spring_boot.service.impl;

import com.spring_boot.model.Blog;
import com.spring_boot.repository.IBlogRepository;
import com.spring_boot.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
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
    public Blog findById(Integer id) {
        return repository.findById(id).orElse(new Blog());
    }

    @Override
    public void update(Blog blog) {
        repository.save(blog);
    }

    @Transactional
    @Override
    public void remove(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable, String name, String note) {
        return this.repository.findAllByNameAndAuthor(pageable, "%" + name + "%", "%" + note + "%");
    }

}