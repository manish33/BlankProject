package com.example.BlankProject.Service;

import com.example.BlankProject.Models.Slot;
import com.example.BlankProject.Models.Ticket;
import com.example.BlankProject.Models.Vehicle;
import com.example.BlankProject.Repository.TicketRepository;

import java.util.UUID;

public class EntrygateService {

    TicketRepository ticketRepository;
    public EntrygateService(TicketRepository ticketRepository) {
        this.ticketRepository=ticketRepository;
    }

    public Ticket getTicket(Slot slot, Vehicle vehicle1){
        Ticket ticket = new Ticket(UUID.randomUUID().toString(),slot, vehicle1);
        ticketRepository.saveTheTicket(slot,ticket);
        return ticket;
    }

    public Ticket getTicketForVehicle(Vehicle vehicle){
       return ticketRepository.getTicket(vehicle);
    }

}
