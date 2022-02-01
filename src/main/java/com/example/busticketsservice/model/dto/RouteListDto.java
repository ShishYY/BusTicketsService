package com.example.busticketsservice.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class RouteListDto {

    private String fromStation;

    private String whereStation;

    private int seatsNumber;

    private Date departureDate;

    private float price;

}
