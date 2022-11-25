package com.spring_boot.repository;

import com.spring_boot.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findByName(String keyword);
    List<Blog> findByNameContaining(String keyword);

    /*Tìm theo tên tương đối và ID lớn hơn 2*/
    List<Blog> findAllBy();
    List<Blog> findByNameContainingAndIdGreaterThan(String keyword, int id);

    @Query(value = "select * from Student where name =:keyword", nativeQuery = true)
    List<Blog> searchByName(@Param("keyword") String keyword);

}