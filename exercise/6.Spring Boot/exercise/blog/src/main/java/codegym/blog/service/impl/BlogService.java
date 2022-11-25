package codegym.blog.service.impl;


import codegym.blog.model.Blog;
import codegym.blog.repository.IBlogRepository;
import codegym.blog.service.IBlogService;
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
    public Blog findById(Integer id) {
        return repository.findById(id).orElse(new Blog());
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