package com.example.service;

import com.example.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBookService extends IGeneralService<Book> {
    @Override
    Iterable<Book> findAll();

    @Override
    Book findById(Integer id);

    @Override
    void save(Book book);

    @Override
    void remove(Integer id);

    @Override
    List<Book> findListAll();

    @Override
    Page<Book> findPageAll(Pageable pageable, String name);
}