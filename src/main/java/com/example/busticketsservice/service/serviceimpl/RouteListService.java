package com.example.busticketsservice.service.serviceimpl;

import com.example.busticketsservice.persistence.entity.RouteListEnity;
import com.example.busticketsservice.persistence.repository.RouteListRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteListService {

    private final RouteListRepository routeListRepository;

    public RouteListService(RouteListRepository routeListRepository) {
        this.routeListRepository = routeListRepository;
    }

    public List<RouteListEnity> getAllRoute(){

        List<RouteListEnity> resultList = routeListRepository.findAll();
                return resultList;
    }
}
