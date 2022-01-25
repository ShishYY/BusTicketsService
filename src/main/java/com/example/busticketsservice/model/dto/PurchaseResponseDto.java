package com.example.busticketsservice.model.dto;

import lombok.Data;

@Data
public class PurchaseResponseDto {

    public Long ticketsId;

    public String purchaseStatus;

    public PurchaseResponseDto(Long ticketsId, String purchaseStatus) {
        this.ticketsId = ticketsId;
        this.purchaseStatus = purchaseStatus;
    }
}
