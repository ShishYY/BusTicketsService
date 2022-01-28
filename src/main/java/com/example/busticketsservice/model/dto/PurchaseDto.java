package com.example.busticketsservice.model.dto;

import lombok.Data;

@Data
public class PurchaseDto {

    private String firstName;

    private String lastName;

    private Long routeId;

    private float amount;

}
