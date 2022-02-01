package com.example.busticketsservice.service.serviceimpl;


import com.example.busticketsservice.model.dto.RouteListDto;
import com.example.busticketsservice.model.dto.UpdateUserDto;
import com.example.busticketsservice.model.dto.UserDto;
import com.example.busticketsservice.persistence.entity.RoleEntity;
import com.example.busticketsservice.persistence.entity.RouteListEntity;
import com.example.busticketsservice.persistence.entity.UserEntity;
import com.example.busticketsservice.persistence.repository.RouteListRepository;
import com.example.busticketsservice.persistence.repository.TicketsRepository;
import com.example.busticketsservice.persistence.repository.UserRepository;
import com.example.busticketsservice.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import static java.util.Arrays.asList;

@Service
@Slf4j
@Transactional
public class AdminServiceImp implements AdminService {

    private final UserRepository userRepository;
    private final RouteListRepository routeListRepository;
    private final TicketsRepository ticketsRepository;

    public AdminServiceImp(UserRepository userRepository, RouteListRepository routeListRepository, TicketsRepository ticketsRepository) {
        this.userRepository = userRepository;
        this.routeListRepository = routeListRepository;
        this.ticketsRepository = ticketsRepository;
    }


    @Override
    public void deleteUser(Long id) throws RuntimeException {
        UserEntity user = userRepository.findById(id).orElse(null);
        if (user == null){
            throw new RuntimeException("User with"+ id +"not found");
        }
        log.info("User with id:{} deleted",id);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<UserEntity> list = userRepository.findAll();
        List<UserDto> dtoList = new ArrayList<>();
        list.forEach(user -> {
            List<String> roleList = new ArrayList<>();
            user.getRoles().forEach(roleEntity -> {
               roleList.add(roleEntity.getRoleName());
            });
           dtoList.add(new UserDto
                          (user.getId(),
                           user.getFirstName(),
                           user.getLastName(),
                           user.getLogin(),
                           user.getEmail(),
                                  roleList));
        });
       return dtoList;
    }
    @Override
    public void updateUser(UpdateUserDto updateUser) {

    }

    @Override
    public void addRoute(RouteListDto routeListDto) {
        RouteListEntity route = new RouteListEntity();

        route.setFromStation(routeListDto.getFromStation());
        route.setWhereStation(routeListDto.getWhereStation());
        route.setSeatsInRoute(routeListDto.getSeatsNumber());
        route.setFreeSeats(routeListDto.getSeatsNumber());
        route.setDepartureTime(routeListDto.getDepartureDate());
        route.setPrice(routeListDto.getPrice());

        routeListRepository.save(route);

        log.info("Route saved");
    }

    @Override
    public void deleteRoute(Long routeId) {

    }

    @Override
    public void updateRoute(RouteListDto routeListDto) {

    }

    @Override
    public void getAllTicketsFromRoute(Long routeId) {

    }


}
