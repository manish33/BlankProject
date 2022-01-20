package com.example.BlankProject.Stratergy;

import com.example.BlankProject.Models.ParkingLot;
import com.example.BlankProject.Models.Slot;
import com.example.BlankProject.Repository.ParkingRepository;

import java.util.Set;
import java.util.stream.Collectors;

public class SimpleStratergy implements ISlotStratergy {

    ParkingRepository parkingRepositor;
    public SimpleStratergy(ParkingRepository parkingRepository) {
        this.parkingRepositor=parkingRepository;
    }

    public Slot getTheSlot(String id) {
        ParkingLot parkingLot = parkingRepositor.getParkingLot(id);
        if(parkingLot==null){
            System.out.println("ok");
        }
        Set<Slot> slots= parkingLot.getSlots();

       for(Slot slot: slots){
           if(slot.isAvailable()){
               return slot;
           }
       }
       return null;
    }
}
