package com.example.busticketsservice.controler;

import com.example.busticketsservice.model.dto.BuyTicketDto;
import com.example.busticketsservice.model.dto.ResponseTicketInfoDto;
import com.example.busticketsservice.persistence.entity.RouteListEntity;
import com.example.busticketsservice.service.serviceimpl.RouteListService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/routes")
public class TicketsSystemController {

    private final RouteListService routeListService;

    public TicketsSystemController(RouteListService routeListService) {
        this.routeListService = routeListService;
    }

    @GetMapping()
    public List<RouteListEntity> getAllRoutes() {
        return routeListService.getAllRoute();
    }

    @PostMapping(value = "/order")
    public Long doOrder(@RequestBody BuyTicketDto buyTicketDto) {
        return routeListService.doOrder(buyTicketDto);
    }

    @GetMapping(value = "/ticketinfo/{id}")
    public ResponseTicketInfoDto ticketInfo(@PathVariable Long id) {
        return routeListService.ticketInfo(id);
    }
}
