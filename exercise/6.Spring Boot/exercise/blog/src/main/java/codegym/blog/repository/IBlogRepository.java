package codegym.blog.repository;


import codegym.blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    @Query(value = "select * from Student where name =:keyword", nativeQuery = true)
    List<Blog> searchByName(@Param("keyword") String keyword);
}