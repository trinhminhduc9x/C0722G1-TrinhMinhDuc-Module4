package com.example.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();

   T findById(Integer id);

    void save(T t);

    void remove(Integer id);

    public List<T> findListAll() ;



    Page<T> findPageAll(Pageable pageable, String name);
}