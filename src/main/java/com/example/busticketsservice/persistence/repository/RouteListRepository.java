package com.example.busticketsservice.persistence.repository;

import com.example.busticketsservice.persistence.entity.RouteListEnity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteListRepository extends JpaRepository<RouteListEnity,Long> {

}
