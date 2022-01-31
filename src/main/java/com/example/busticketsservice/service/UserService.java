package com.example.busticketsservice.service;

import com.example.busticketsservice.persistence.entity.UserEntity;

import java.util.List;

public interface UserService {

    UserEntity register(UserEntity user);

    List<UserEntity> getAllUser();

    UserEntity findByEmail(String email);

    UserEntity findById(Long id);

    void delete (Long id);
}
