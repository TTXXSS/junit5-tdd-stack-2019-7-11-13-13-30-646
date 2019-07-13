package com.thoughtworks.tdd;

import java.util.List;
import java.util.Map;

public class SmartParkingBoy extends ParkingBoy {
    public SmartParkingBoy(List<Map<Ticket, Car>> parkingLot) {
        super(parkingLot);
    }

    @Override
    public Ticket park(Car car) {
        Ticket ticket = new Ticket();
        //System.out.println(this.parkingLot.getMap().size());
        int length = this.parkingLot.size();
        boolean flag = false;
        int minLength=this.parkingLot.get(0).size();
        for (int i = 0; i < length; i++) {
            if(this.parkingLot.get(i).size()<minLength)
                minLength=this.parkingLot.get(i).size();
        }
        for (int i = 0; i < length; i++) {
            int lengthOfMap = this.parkingLot.get(i).size();
            if(minLength==lengthOfMap) {
                if (lengthOfMap < 10) {
                    this.parkingLot.get(i).put(ticket, car);
                    flag = true;
                    break;
                }
            }
        }
        if (flag)
            return ticket;
        else
            return null;
    }
}
