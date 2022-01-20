package com.example.BlankProject.Models;

enum SlotType{
    Default;
}

public class Slot {
    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    SlotType slotType;
    Vehicle vehicle;
    boolean isAvailable;

    public SlotType getSlotType() {
        return slotType;
    }

    public void setSlotType(SlotType slotType) {
        this.slotType = slotType;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Slot(String id, boolean isAvailable) {
        this.id = id;
        this.slotType = slotType;
        this.isAvailable = isAvailable;
    }

    public boolean isSlotAvailable(){
        return this.isAvailable;
    }

    public boolean parkVehicle(Vehicle vehicle){
        this.vehicle=vehicle;
        isAvailable=false;
        return true;
    }
}
