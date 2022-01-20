package com.example.BlankProject.Models;

import java.util.Date;

public class Ticket {
    String id;
    Slot slot;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    Vehicle vehicle;
    Date arrivalTime;
    Date exitTime;
    float amount;

    public Ticket(String id, Slot slot, Vehicle vehicle) {
        this.id = id;
        this.slot = slot;
        this.vehicle = vehicle;
        this.arrivalTime = new Date();
    }
}
