package com.example.busticketsservice.model.dto;

import lombok.Data;

@Data
public class PurchaseDto {

    private String firstName;

    private String lastName;

    private Long routeId;

    private float amount;

    public PurchaseDto(String firstName, String lastName, Long routeId, float amount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.routeId = routeId;
        this.amount = amount;
    }
}
