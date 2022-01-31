package com.example.busticketsservice.service.serviceimpl;

import com.example.busticketsservice.model.dto.BuyTicketDto;
import com.example.busticketsservice.model.dto.ResponseTicketInfoDto;
import com.example.busticketsservice.persistence.entity.RouteListEnity;
import com.example.busticketsservice.persistence.entity.TicketEntity;
import com.example.busticketsservice.persistence.repository.RouteListRepository;
import com.example.busticketsservice.persistence.repository.TicketsRepository;
import com.example.busticketsservice.service.TicketFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public List<RouteListEnity> getAllRoute() {

        List<RouteListEnity> resultList = routeListRepository.findAll();
        return resultList;
    }

    public Long doOrder(BuyTicketDto buyTicketDto) {
        if (hasFreeTickets(buyTicketDto.getRouteId())) {
            RouteListEnity routeList = routeListRepository.findById(buyTicketDto.getRouteId()).get();
            TicketEntity ticket = TicketFactory.createTicket(buyTicketDto, routeList);
            ticketsRepository.save(ticket);
            routeList.setFreeSeats(routeList.getFreeSeats() - 1);
            routeListRepository.save(routeList);
            return ticket.getId();
        }
        throw new RuntimeException("There no free seats in this route");
    }

    public boolean hasFreeTickets(Long id) {
        RouteListEnity routeListEnity = routeListRepository.findById(id).get();
        return routeListEnity.getFreeSeats() > 0;
    }

    public ResponseTicketInfoDto ticketInfo(Long id) {
        TicketEntity ticket = ticketsRepository.findById(id).get();
        RouteListEnity routeList = ticket.getRouteListEnity();
        return new ResponseTicketInfoDto(routeList.getFromStation(),
                routeList.getWhereStation(),
                routeList.getDepartureTime(),
                ticket.getPurchaseStatus());
    }


}
