package com.example.busticketsservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ResponseTicketInfoDto {

    private String fromStation;

    private String whereStation;

    private Date departureTime;

    private String payStatus;


}
