package com.example.busticketsservice.controler;


import com.example.busticketsservice.model.dto.RouteListDto;
import com.example.busticketsservice.model.dto.UpdateUserDto;
import com.example.busticketsservice.service.UserService;
import com.example.busticketsservice.service.serviceimpl.RouteListService;
import com.example.busticketsservice.service.serviceimpl.TicketsPayServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/admin")
public class AdminController {




    public void deleteUser(Long id){};

    public void updateUser(UpdateUserDto updateUser){};

    public void addRoute(RouteListDto routeListDto){};

    public void deleteRoute(Long routeId){};

    public void updateRoute(RouteListDto routeListDto){};

    public void getAllTicketsFromRoute(Long routeId){};




}
