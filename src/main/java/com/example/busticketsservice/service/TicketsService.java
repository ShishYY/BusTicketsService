package com.example.busticketsservice.service;

import com.example.busticketsservice.model.dto.PurchaseDto;

public interface TicketsService {

    String doPurchase(String uniqueId);

    String payTicket(PurchaseDto purchase);

    String generateUniqueId();
}
