package com.example.busticketsservice.service.serviceimpl;

import com.example.busticketsservice.model.dto.PurchaseDto;
import com.example.busticketsservice.model.dto.PurchaseResponseDto;
import com.example.busticketsservice.persistence.EPayStatus;
import com.example.busticketsservice.persistence.repository.RouteListRepository;
import com.example.busticketsservice.persistence.repository.TicketsRepository;
import com.example.busticketsservice.service.TicketsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.Random;
import java.util.UUID;


@Service
@Slf4j
public class TicketsPayServiceImpl implements TicketsService {

    private final TicketsRepository ticketsRepository;
    private final RouteListRepository routeListRepository;

    public TicketsPayServiceImpl(TicketsRepository ticketsRepository, RouteListRepository routeListRepository) {
        this.ticketsRepository = ticketsRepository;
        this.routeListRepository = routeListRepository;
    }

    /*public void doOrder(OrderDto order) {
            //если платеж вернул Done зарегить билет и отправить статус куплено
        RouteListEnity route = routeListRepository.getById(order.getRouteId());
        if(order.getPurchaseStatus().equals(EPayStatus.DONE.toString())) {
            TicketEntity ticket = new TicketEntity();
            ticket.setFirstName(order.getFirstName());
            ticket.setLastName(order.getLastName());
            ticket.setRouteListEnity(route);
        }
        }*/

        //todo сделать выборку из бд по Id билета
        @Override
        public String getPurchaseStatus (String uniq){
            StringBuilder result = new StringBuilder();
            int e = new Random().nextInt(3);
            switch (e) {
                case 0:
                    result.append(EPayStatus.DONE);
                    break;
                case 1:
                    result.append(EPayStatus.FAILED);
                    break;
                case 2:
                    result.append(EPayStatus.NEW);
                    break;
            }
            return result.toString();
        }

        @Override
        public PurchaseResponseDto payTicket (PurchaseDto purchase){
            return new PurchaseResponseDto();
        }

        @Override
        public String generateUniqueId (String data){
            return UUID.randomUUID().toString().substring(0,8);
        }
    }

