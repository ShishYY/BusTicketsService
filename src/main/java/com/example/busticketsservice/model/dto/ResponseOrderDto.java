package com.example.busticketsservice.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ResponseOrderDto {

    private Long ticketId;

    private String route;

    private Date departureDay;


}
