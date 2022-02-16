package com.example.busticketsservice.controler;


import com.example.busticketsservice.model.dto.RouteListDto;
import com.example.busticketsservice.model.dto.UpdateUserDto;
import com.example.busticketsservice.model.dto.UserDto;
import com.example.busticketsservice.persistence.entity.UserEntity;
import com.example.busticketsservice.service.serviceimpl.AdminServiceImp;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/admin")
public class AdminController {

    private final AdminServiceImp adminService;

    public AdminController(AdminServiceImp adminService) {
        this.adminService = adminService;
    }

    @DeleteMapping(value = "/user/{id}")
    public void deleteUser(@PathVariable Long id){};

    @GetMapping(value = "/users")
    public List<UserDto> getAllUser(){
        return adminService.getAllUsers();
    }

    @PutMapping("/user")
    public void updateUser(UpdateUserDto updateUser){};

    @PostMapping("/route")
    public void addRoute(@RequestBody RouteListDto routeListDto){
        adminService.addRoute(routeListDto);
    };

    @DeleteMapping("/route/{routeId}")
    public void deleteRoute(@PathVariable Long routeId){
        adminService.deleteRoute(routeId);
    };

    @PutMapping("/route")
    public void updateRoute(RouteListDto routeListDto){};

    @GetMapping("/tickets")
    public void getAllTicketsFromRoute(Long routeId){};
}
