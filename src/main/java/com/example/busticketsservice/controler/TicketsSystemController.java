package com.example.busticketsservice.controler;

import com.example.busticketsservice.persistence.entity.RouteListEnity;
import com.example.busticketsservice.service.serviceimpl.RouteListService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/routes")
public class TicketsSystemController {

   private final RouteListService routeListService;

    public TicketsSystemController(RouteListService routeListService) {
        this.routeListService = routeListService;
    }

    @GetMapping()
    public List<RouteListEnity> getAllRoutes(){
            return routeListService.getAllRoute();
        }
}
