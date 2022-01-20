package com.example.BlankProject.Models;

import java.util.UUID;

public class EntryGate implements Gate {

    public Ticket createAticket(String id,Vehicle vehicle,Slot slot){
        return new Ticket(id,slot,vehicle);
    }
}
