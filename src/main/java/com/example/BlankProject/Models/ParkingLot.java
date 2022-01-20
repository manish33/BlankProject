package com.example.BlankProject.Models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class ParkingLot {
    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<Slot> getSlots() {
        return slots;
    }

    public void setSlots(Set<Slot> slots) {
        this.slots = slots;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    Set<Slot> slots;
    String address;
    EntryGate entryGate;
    ExitGate exitGate;

    public EntryGate getEntryGate() {
        return entryGate;
    }

    public void setEntryGate(EntryGate entryGate) {
        this.entryGate = entryGate;
    }

    public ExitGate getExitGate() {
        return exitGate;
    }

    public void setExitGate(ExitGate exitGate) {
        this.exitGate = exitGate;
    }

    public ParkingLot(String id) {
        this.id = id;
        slots = new HashSet<>();
        address="random address";
    }


    public void  addSlot(Slot slot){
        slots.add(slot);
    }

    public void  removeSlot(Slot slot){
        slots.remove(slot);
    }

}
