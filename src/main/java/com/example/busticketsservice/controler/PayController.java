package com.example.busticketsservice.controler;

import com.example.busticketsservice.model.dto.PurchaseDto;
import com.example.busticketsservice.model.dto.PurchaseResponseDto;
import com.example.busticketsservice.service.serviceimpl.TicketsPayServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class PayController {

    private final TicketsPayServiceImpl ticketsPayService;

    public PayController(TicketsPayServiceImpl ticketsPayService) {
        this.ticketsPayService = ticketsPayService;
    }

    @PostMapping(value = "/pay")
    public PurchaseResponseDto payTicket(@RequestBody() PurchaseDto purchase){
        return ticketsPayService.payTicket(purchase);
    }

    @GetMapping(value = "/pay/status/{uniqueId}")
    public String getPayStatus(@PathVariable String uniqueId){
        return ticketsPayService.getPurchaseStatus(uniqueId);
    }

}

