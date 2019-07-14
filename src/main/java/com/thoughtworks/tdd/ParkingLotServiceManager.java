package com.thoughtworks.tdd;

import java.util.List;
import java.util.Map;

public class ParkingLotServiceManager {
    private List<ParkingBoy> listOfParkingBoy;
    private List<Map<Ticket, Car>> parkingLot;

    public List<Map<Ticket, Car>> getListOfParkingLot() {
        return parkingLot;
    }

    public void setListOfParkingLot(List<Map<Ticket, Car>> parkingLot) {
        this.parkingLot = parkingLot;
    }

    public List<ParkingBoy> getListOfParkingBoy() {
        return listOfParkingBoy;
    }

    public void setListOfParkingBoy(List<ParkingBoy> list) {
        this.listOfParkingBoy = list;
    }
    public ParkingBoy getParkingBoyByIndex(List<ParkingBoy> listOfThreeKindsOfParkingBoy,int i){
        return listOfThreeKindsOfParkingBoy.get(i);
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
}
