package com.example.busticketsservice.service.serviceimpl;

import com.example.busticketsservice.model.dto.PurchaseDto;
import com.example.busticketsservice.persistence.EPayStatus;
import com.example.busticketsservice.persistence.entity.TicketEntity;
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

    public TicketsPayServiceImpl(TicketsRepository ticketsRepository) {
        this.ticketsRepository = ticketsRepository;
    }


    @Override
    public String doPurchase(String uniq) {
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
        TicketEntity ticket = ticketsRepository.findByUniquePayId(uniq);
        ticket.setPurchaseStatus(result.toString());
        ticketsRepository.save(ticket);
        return result.toString();
    }

    @Override
    public String payTicket(PurchaseDto purchase) {
        TicketEntity ticket = ticketsRepository.
                findByFirstNameAndLastNameAndRouteListEnity_Price(purchase.getFirstName(), purchase.getLastName(), purchase.getAmount());
        String uniqueId = generateUniqueId();
        ticket.setUniquePayId(uniqueId);
        ticketsRepository.save(ticket);
        return uniqueId;
    }

    @Override
    public String generateUniqueId() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

}

