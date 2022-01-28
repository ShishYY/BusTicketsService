package com.example.busticketsservice.service;

import com.example.busticketsservice.persistence.EPayStatus;
import com.example.busticketsservice.persistence.entity.RouteListEnity;
import com.example.busticketsservice.persistence.entity.TicketEntity;
import com.example.busticketsservice.persistence.repository.RouteListRepository;
import com.example.busticketsservice.persistence.repository.TicketsRepository;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Component
@EnableScheduling
public class TicketMonitor {

  private final TicketsRepository ticketsRepository;
  private final RouteListRepository routeListRepository;

   public TicketMonitor(TicketsRepository ticketsRepository, RouteListRepository routeListRepository) {
      this.ticketsRepository = ticketsRepository;
       this.routeListRepository = routeListRepository;
   }
   @Scheduled(fixedRateString = "${fixedRate.in.milliseconds}")
   public void startMonitor(){
       new Monitor().checkTicketPayStatus();
   }

   @Transactional
   class Monitor {

       public  void checkTicketPayStatus(){
           List<TicketEntity> ticketEntityList = ticketsRepository.findAll();
           ticketEntityList.forEach(ticketEntity -> {
               if (ticketEntity.getPurchaseStatus().equals(EPayStatus.FAILED.toString())
                       || ticketEntity.getPurchaseStatus().equals(EPayStatus.NEW.toString())){
                   RouteListEnity routeListEnity = ticketEntity.getRouteListEnity();
                   int temp = routeListEnity.getFreeSeats();
                   routeListEnity.setFreeSeats(temp+1);
                   routeListRepository.save(routeListEnity);
                   ticketsRepository.delete(ticketEntity);
               }
           });
       }
   }
}
