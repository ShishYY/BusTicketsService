package com.example.busticketsservice.service;

import com.example.busticketsservice.model.dto.PurchaseDto;
import com.example.busticketsservice.model.dto.PurchaseResponseDto;

public interface TicketsService {

    String getPurchaseStatus(String uniqueId);

    PurchaseResponseDto payTicket(PurchaseDto purchase);

    String generateUniqueId(String data);
}
