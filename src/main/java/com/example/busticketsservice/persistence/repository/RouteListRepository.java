package com.example.busticketsservice.persistence.repository;

import com.example.busticketsservice.persistence.entity.RouteListEnity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface RouteListRepository extends JpaRepository<RouteListEnity, Long> {


    Optional<RouteListEnity> findById(Long id);
}
