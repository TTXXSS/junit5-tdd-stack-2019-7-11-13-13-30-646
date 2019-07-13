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
        //System.out.println(this.parkingLot.getMap().size());
        if (this.parkingLot.getMap().size() >= 10)
            return null;
        parkingLot.getMap().put(ticket, car);
        return ticket;
    }

    public Car fetchCar(Ticket fetchTicket) {
        Map<Ticket, Car> map = this.parkingLot.getMap();
        Car car;
        if (fetchTicket == null)
            return null;
        else
            car = map.get(fetchTicket);
        if (car != null)
            return map.remove(fetchTicket);
        else
            return null;
    }


    public String giveTipMessageByFetchCar(Ticket fetchTicket) {
        if(this.parkingLot.getMap().size()>=10)
            return "Not enough position.";
        if (fetchTicket == null)
            return "Please provide your parking ticket.";
        if (this.parkingLot.getMap().get(fetchTicket) == null)
            return "Unrecognized parking ticket.";
        return null;
    }
}
