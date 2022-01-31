package com.example.busticketsservice.persistence.repository;

import com.example.busticketsservice.persistence.entity.RouteListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface RouteListRepository extends JpaRepository<RouteListEntity, Long> {


    Optional<RouteListEntity> findById(Long id);
}
