package com.example.service;

import com.example.model.OrderacsAndPayacs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IOandPservice extends IGeneralService<OrderacsAndPayacs>{
    @Override
    List<OrderacsAndPayacs> findListAll();

    @Override
    Iterable<OrderacsAndPayacs> findAll();

    @Override
    OrderacsAndPayacs findById(Integer id);

    @Override
    void save(OrderacsAndPayacs orderacsAndPayacs);

    @Override
    void remove(Integer id);

    @Override
    Page<OrderacsAndPayacs> findPageAll(Pageable pageable, String name);

}
