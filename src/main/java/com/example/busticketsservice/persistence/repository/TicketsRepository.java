package com.example.busticketsservice.persistence.repository;

import com.example.busticketsservice.persistence.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TicketsRepository extends JpaRepository<TicketEntity,Long> {

    TicketEntity findByFirstNameAndLastNameAndRouteListEnity_Price(String firstName , String lastName, float price);

    TicketEntity findByUniquePayId(String uniq);
}
