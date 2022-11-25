package codegym.blog.service;



import codegym.blog.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    Blog findById(Integer id);

    void update(Blog blog);

    void remove(int id);
}