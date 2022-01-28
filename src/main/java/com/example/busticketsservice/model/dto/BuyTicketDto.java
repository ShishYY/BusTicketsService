package com.example.busticketsservice.model.dto;

import lombok.Data;

@Data
public class BuyTicketDto {

    private String firstName;

    private String lastName;

    private Long routeId;
}
