package com.example.busticketsservice.persistence.repository;

import com.example.busticketsservice.persistence.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketsRepository extends JpaRepository<TicketEntity,Long> {
}
