package com.example.busticketsservice.service;

import com.example.busticketsservice.model.dto.BuyTicketDto;
import com.example.busticketsservice.persistence.EPayStatus;
import com.example.busticketsservice.persistence.entity.RouteListEnity;
import com.example.busticketsservice.persistence.entity.TicketEntity;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public final class TicketFactory {

    @Getter
    public static String defaultStatus;

    @Value("${default.purchase.status}")
    public void setDatabase(String db) {
        defaultStatus = db;
    }

        public static TicketEntity createTicket(BuyTicketDto buyTicketDto, RouteListEnity routeListEnity){
        TicketEntity ticket = new TicketEntity();
        ticket.setFirstName(buyTicketDto.getFirstName());
        ticket.setLastName(buyTicketDto.getLastName());
        ticket.setRouteListEnity(routeListEnity);
        ticket.setPurchaseStatus(defaultStatus);
        return ticket;
    }
}
