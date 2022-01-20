package com.example.BlankProject.Controllers;


import com.example.BlankProject.Models.EntryGate;
import com.example.BlankProject.Models.ParkingLot;
import com.example.BlankProject.Models.Slot;
import com.example.BlankProject.Models.Ticket;
import com.example.BlankProject.Models.Vehicle;
import com.example.BlankProject.Repository.ParkingRepository;
import com.example.BlankProject.Repository.TicketRepository;
import com.example.BlankProject.Service.EntrygateService;
import com.example.BlankProject.Stratergy.ISlotStratergy;
import com.example.BlankProject.Stratergy.SimpleStratergy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.UUID;

@Controller
public class ParkingController {

    ParkingRepository parkingRepository= new ParkingRepository();
    ISlotStratergy slotStratergy= new SimpleStratergy(parkingRepository);
    TicketRepository ticketRepository = new TicketRepository();
    EntrygateService entrygateService= new EntrygateService(ticketRepository);

    @PostMapping("/createParkingLot")
    public ResponseEntity<String>  createParkingLot(){
        ParkingLot parkingLot = new ParkingLot(UUID.randomUUID().toString());
        parkingRepository.saveParkingLot(parkingLot);
        return new ResponseEntity(parkingLot.getId(),HttpStatus.OK);
    }

    @PostMapping("/add/slot/{id}")
    public ResponseEntity<Slot> addSlotToParkingLot(@PathVariable String id){

       ParkingLot parkingLot = parkingRepository.getParkingLot(id);
       if(parkingLot==null){
           return new ResponseEntity(HttpStatus.BAD_REQUEST);
       }
        Slot slot=new Slot(UUID.randomUUID().toString(),true);
       parkingLot.addSlot(slot);
       return new ResponseEntity(slot,HttpStatus.OK);
    }

    @PostMapping("/parkAvehicle/parkingLot/{id}/{vehicleId}")
    public  ResponseEntity<Ticket> assignAticket(@PathVariable("id") String id,@PathVariable("vehicleId") String vehicleId){
        Slot slot = slotStratergy.getTheSlot(id);
        Vehicle vehicle1 = new Vehicle(vehicleId);
        Ticket ticket =  entrygateService.getTicket(slot,vehicle1);
        return new ResponseEntity<Ticket>(ticket,HttpStatus.OK);
    }

    @GetMapping("/getSlotForVehicle/parkingLot/{parkingLotId}/{vehicleId}")
    public ResponseEntity<Slot> getTheSlot(@PathVariable String parkingLotId,@PathVariable String vehicleId){
        Ticket ticket =entrygateService.getTicketForVehicle(new Vehicle(vehicleId));
        return new ResponseEntity<>(ticket.getSlot(),HttpStatus.OK);
    }

    @PostMapping("/getSlotForVehicle/parkingLot/{parkingLotId}/{vehicleId}")
    public ResponseEntity<Integer> exitTheVehicle(@PathVariable String parkingLotId,@PathVariable String vehicleId){
        Ticket ticket =entrygateService.getTicketForVehicle(new Vehicle(vehicleId));
        ticket.getSlot().setAvailable(true);
        Integer diff = 10;
        return new ResponseEntity<Integer>(diff,HttpStatus.OK);
    }


}
