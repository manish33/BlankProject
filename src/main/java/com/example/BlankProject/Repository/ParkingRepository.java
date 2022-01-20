package com.example.BlankProject.Repository;

import com.example.BlankProject.Models.ParkingLot;
import com.example.BlankProject.Models.Slot;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class ParkingRepository {
    HashMap<String, ParkingLot> parkingLotHashMap= new HashMap<>();
    HashMap<String, Set<Slot>> ParkingLotToslotHashMap= new HashMap<>();
    HashMap<String, Slot> slots = new HashMap<>();
    public HashMap<String, ParkingLot> getParkingLotHashMap() {
        return parkingLotHashMap;
    }

    public void setParkingLotHashMap(HashMap<String, ParkingLot> parkingLotHashMap) {
        this.parkingLotHashMap = parkingLotHashMap;
    }

    public HashMap<String, Set<Slot>> getParkingLotToslotHashMap() {
        return ParkingLotToslotHashMap;
    }

    public void setParkingLotToslotHashMap(HashMap<String, Set<Slot>> parkingLotToslotHashMap) {
        ParkingLotToslotHashMap = parkingLotToslotHashMap;
    }

    public HashMap<String, Slot> getSlots() {
        return slots;
    }

    public void setSlots(HashMap<String, Slot> slots) {
        this.slots = slots;
    }



    public  void  saveParkingLot(ParkingLot parkingLot){
        parkingLotHashMap.put(parkingLot.getId(),parkingLot);
    }
    public ParkingLot getParkingLot(String id){
        return parkingLotHashMap.get(id);
    }
    public void addSlottoParkingLot(ParkingLot parkingLot,Slot slot){
        ParkingLotToslotHashMap.get(parkingLot.getId()).add(slot);
        slots.put(slot.getId(),slot);
    }
}
