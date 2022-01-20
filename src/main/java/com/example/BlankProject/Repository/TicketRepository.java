package com.example.BlankProject.Repository;

import com.example.BlankProject.Models.Slot;
import com.example.BlankProject.Models.Ticket;
import com.example.BlankProject.Models.Vehicle;

import java.util.HashMap;
import java.util.UUID;

public class TicketRepository {

    HashMap<String, Ticket> slotIdToTicketMap= new HashMap<>();
    HashMap<Vehicle, Ticket> vehicleIdToTicketMap= new HashMap<>();



    public Ticket getTicket(Vehicle vehicle){
        return vehicleIdToTicketMap.get(vehicle);
    }

    public void saveTheTicket(Slot slot,Ticket ticket){
        slotIdToTicketMap.put(slot.getId(),ticket);
    }

    public Ticket getVehicleFromTicket(Vehicle vehicle){
        return vehicleIdToTicketMap.get(vehicle);
    }
}
