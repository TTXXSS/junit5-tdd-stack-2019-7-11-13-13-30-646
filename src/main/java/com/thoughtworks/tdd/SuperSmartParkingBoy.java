package com.thoughtworks.tdd;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SuperSmartParkingBoy extends ParkingBoy {
    public SuperSmartParkingBoy(List<Map<Ticket, Car>> parkingLot) {
        super(parkingLot);
    }

    @Override
    public Ticket park(Car car) {
        Ticket ticket = new Ticket();
        int length = this.parkingLot.size();
        double[] rate = new double[length];
        for (int i = 0; i < length; i++) {
            rate[i] = this.parkingLot.get(i).size() * 1.0 / 10;
        }
        //Arrays.sort(rate);
        double temp = rate[0];
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (rate[i] < temp) {
                temp = rate[i];
                index = i;
            }
        }
        if(this.parkingLot.get(index).size()==10)
            return null;
        else {
            this.parkingLot.get(index).put(ticket, car);
            return ticket;
        }
    }

}
