package com.spring_boot.repository;

import com.spring_boot.model.Category;
import com.spring_boot.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {


    @Query(value = " select * from category where name like :name ", nativeQuery = true)
    Page<Category> findAllByName(Pageable pageable, @Param("name") String name);

    @Query(value = " select * from blog where category_id like :id ", nativeQuery = true)
    List<Blog> findListById(  @Param("id") Integer id);







}
