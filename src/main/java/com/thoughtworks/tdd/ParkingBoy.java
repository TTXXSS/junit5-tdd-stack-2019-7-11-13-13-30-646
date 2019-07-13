package com.thoughtworks.tdd;

import java.util.List;
import java.util.Map;

public class ParkingBoy {
    protected List<Map<Ticket, Car>> parkingLot;

    public ParkingBoy(List<Map<Ticket, Car>> parkingLot) {
        this.parkingLot = parkingLot;
    }

    public List<Map<Ticket, Car>> getParkingLot() {
        return parkingLot;
    }

    public Ticket park(Car car) {
        Ticket ticket = new Ticket();
        //System.out.println(this.parkingLot.getMap().size());
        int length = this.parkingLot.size();
        boolean flag = false;
        for (int i = 0; i < length; i++) {
            int lengthOfMap = this.parkingLot.get(i).size();
            if (lengthOfMap < 10) {
                this.parkingLot.get(i).put(ticket, car);
                flag = true;
                break;
            }
        }
        if (flag)
            return ticket;
        else
            return null;
    }

    public Car fetchCar(Ticket fetchTicket) {
        Map<Ticket, Car> map;
        Car car = null;
        int length = this.parkingLot.size();
        if (fetchTicket == null)
            return null;
        for (int i = 0; i < length; i++) {
            map = this.parkingLot.get(i);
            car = map.get(fetchTicket);
            if(car!=null) {
                return map.remove(fetchTicket);
            }

        }
        // System.out.println(this.parkingLot.get(0).size());
            return null;

    }


    public String giveTipMessageByFetchCar(Ticket fetchTicket) {
        int length = this.parkingLot.size();
        for (int i = 0; i < length; i++) {
            if (this.parkingLot.get(i).size() == 10 && fetchTicket == null)
                return "Not enough position.";
            if (fetchTicket == null)
                return "Please provide your parking ticket.";
            if (this.parkingLot.get(i).size() <= 10 && this.parkingLot.get(i).get(fetchTicket) == null)
                return "Unrecognized parking ticket.";
        }
        return null;
    }
}
