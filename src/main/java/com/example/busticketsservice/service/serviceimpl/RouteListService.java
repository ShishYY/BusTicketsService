package com.example.busticketsservice.service.serviceimpl;

import com.example.busticketsservice.model.dto.BuyTicketDto;
import com.example.busticketsservice.model.dto.PurchaseDto;
import com.example.busticketsservice.model.dto.ResponseTicketInfoDto;
import com.example.busticketsservice.persistence.entity.RouteListEntity;
import com.example.busticketsservice.persistence.entity.TicketEntity;
import com.example.busticketsservice.persistence.repository.RouteListRepository;
import com.example.busticketsservice.persistence.repository.TicketsRepository;
import com.example.busticketsservice.service.TicketFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Transactional
public class RouteListService {

    private final RouteListRepository routeListRepository;

    private final TicketsRepository ticketsRepository;

    public RouteListService(RouteListRepository routeListRepository, TicketsRepository ticketsRepository) {
        this.routeListRepository = routeListRepository;
        this.ticketsRepository = ticketsRepository;
    }

    public List<RouteListEntity> getAllRoute() {

        List<RouteListEntity> resultList = routeListRepository.findAll();
        return resultList;
    }

    public Long doOrder(BuyTicketDto buyTicketDto) {
        if (hasFreeTickets(buyTicketDto.getRouteId())) {
            RouteListEntity routeList = routeListRepository.findById(buyTicketDto.getRouteId()).get();
            TicketEntity ticket = TicketFactory.createTicket(buyTicketDto, routeList);
            ticketsRepository.save(ticket);
            routeList.setFreeSeats(routeList.getFreeSeats() - 1);
            routeListRepository.save(routeList);
            payForTicket(buyTicketDto);
            return ticket.getId();
        }
        throw new RuntimeException("There no free seats in this route");
    }

    public boolean hasFreeTickets(Long id) {
        RouteListEntity routeListEnity = routeListRepository.findById(id).get();
        return routeListEnity.getFreeSeats() > 0;
    }

    public ResponseTicketInfoDto ticketInfo(Long id) {
        TicketEntity ticket = ticketsRepository.findById(id).get();
        RouteListEntity routeList = ticket.getRouteListEntity();
        return new ResponseTicketInfoDto(routeList.getFromStation(),
                routeList.getWhereStation(),
                routeList.getDepartureTime(),
                ticket.getPurchaseStatus());
    }

    public String payForTicket(BuyTicketDto buyTicketDto){
        RestTemplate restTemplate = new RestTemplate();/*http://localhost:8083/api/v1/pay*/
        PurchaseDto purchaseDto = new PurchaseDto();
        purchaseDto.setFirstName(buyTicketDto.getFirstName());
        purchaseDto.setLastName(buyTicketDto.getLastName());
        purchaseDto.setAmount(100);
        purchaseDto.setRouteId(buyTicketDto.getRouteId());
        String payStatus =  restTemplate.postForObject("http://localhost:8083/api/v1/pay",purchaseDto,String.class);
        System.out.println(payStatus);
        return payStatus;
    }


}
