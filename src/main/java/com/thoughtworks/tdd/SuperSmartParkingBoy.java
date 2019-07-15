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
        double[] rateOfEmptyPosition = getRateOfEmptyPosition();
        //Arrays.sort(rate);
        double temp = rateOfEmptyPosition[0];
        int index = getIndexOfMinRateOfEmptyPosition(rateOfEmptyPosition,temp);
        if (this.parkingLot.get(index).size() == 10)
            return null;
        else {
            this.parkingLot.get(index).put(ticket, car);
            return ticket;
        }
    }

    public double[] getRateOfEmptyPosition() {
        int length = this.parkingLot.size();
        double[] rate = new double[length];
        for (int i = 0; i < length; i++) {
            rate[i] = this.parkingLot.get(i).size() * 1.0 / 10;
        }
        return rate;
    }

    public int getIndexOfMinRateOfEmptyPosition(double[] rateOfEmptyPosition,double temp){
        int index=0;
        int length = this.parkingLot.size();
        for (int i = 0; i < length; i++) {
            if (rateOfEmptyPosition[i] < temp) {
                temp = rateOfEmptyPosition[i];
                index = i;
            }
        }
        return index;
    }
}
