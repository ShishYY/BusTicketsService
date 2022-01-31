package com.example.busticketsservice.persistence.repository;

import com.example.busticketsservice.persistence.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity,Long> {
    RoleEntity findByRoleName (String name);
}
