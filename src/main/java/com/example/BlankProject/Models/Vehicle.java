package com.example.BlankProject.Models;

public class Vehicle {
    String numberPlate;
    Slot slot;

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public Vehicle(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public boolean assignASlot(Slot slot){
        this.slot=slot;
        return true;
    }
}
