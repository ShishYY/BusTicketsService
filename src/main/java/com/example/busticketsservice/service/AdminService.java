package com.example.busticketsservice.service;

import com.example.busticketsservice.model.dto.RouteListDto;
import com.example.busticketsservice.model.dto.UpdateUserDto;
import com.example.busticketsservice.model.dto.UserDto;
import com.example.busticketsservice.persistence.entity.UserEntity;

import java.util.List;

public interface AdminService {

    void deleteUser(Long id);

    void updateUser(UpdateUserDto updateUser);

    void addRoute(RouteListDto routeListDto);

    void deleteRoute(Long routeId);

    void updateRoute(RouteListDto routeListDto);

    void getAllTicketsFromRoute(Long routeId);

    List<UserDto> getAllUsers();
}
