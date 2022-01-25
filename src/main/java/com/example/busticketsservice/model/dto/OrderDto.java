package com.example.busticketsservice.model.dto;

import lombok.Data;

@Data
public class OrderDto {

    private long routeId;

    private String firstName;

    private String lastName;

    private String purchaseStatus;

}
