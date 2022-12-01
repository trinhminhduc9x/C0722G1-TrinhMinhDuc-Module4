package com.example.repository;

import com.example.model.Book;
import com.example.model.OrderacsAndPayacs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrandPayecr  extends JpaRepository<OrderacsAndPayacs, Integer> {
}
