package com.thoughtworks.tdd;

import java.util.HashMap;
import java.util.Map;

public class ParkingBoy {
    private ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Ticket park(Car car) {
        Ticket ticket = new Ticket();
        parkingLot.getMap().put(ticket,car);
        return ticket;
    }

    public Car fetchCar(Ticket fetchTicket) {
        Map<Ticket,Car> map =this.parkingLot.getMap();
        return map.get(fetchTicket);
    }


}
