package com.example.busticketsservice.service;

import com.example.busticketsservice.model.dto.BuyTicketDto;
import com.example.busticketsservice.persistence.entity.RouteListEntity;
import com.example.busticketsservice.persistence.entity.TicketEntity;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public final class TicketFactory {

    @Getter
    public static String defaultStatus;

    public static TicketEntity createTicket(BuyTicketDto buyTicketDto, RouteListEntity routeListEntity) {
        TicketEntity ticket = new TicketEntity();
        ticket.setFirstName(buyTicketDto.getFirstName());
        ticket.setLastName(buyTicketDto.getLastName());
        ticket.setRouteListEntity(routeListEntity);
        ticket.setPurchaseStatus(defaultStatus);
        return ticket;
    }

    @Value("${default.purchase.status}")
    public void setDatabase(String db) {
        defaultStatus = db;
    }
}
