package com.spring_boot.service;

import com.spring_boot.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(int id);
}
