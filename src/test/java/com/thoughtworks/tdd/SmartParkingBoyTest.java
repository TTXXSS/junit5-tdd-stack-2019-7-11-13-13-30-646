package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmartParkingBoyTest {
    @Test
    public void should_park_the_car_to_min_size_of_parkingLot() {
        //Given
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        Car car4 = new Car();
        Car car5 = new Car();
        Car car6 = new Car();
        Car car7 = new Car();
        Car car8 = new Car();
        Car car9 = new Car();
        Car car10 = new Car();
        Car car11 = new Car();
        Map<Ticket, Car> map = new HashMap<>();
        ParkingLot parkingLot = new ParkingLot();
        Map<Ticket, Car> map1 = new HashMap<>();
        ParkingLot parkingLot1 = new ParkingLot();
        parkingLot.setMap(map);
        parkingLot1.setMap(map1);
        List<Map<Ticket, Car>> list = new ArrayList<>();
        list.add(parkingLot.getMap());
        list.add(parkingLot1.getMap());
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(list);
        Ticket fetchTicket1 = smartParkingBoy.park(car1);
        Ticket fetchTicket2 = smartParkingBoy.park(car2);
        Ticket fetchTicket3 = smartParkingBoy.park(car3);
        Ticket fetchTicket4 = smartParkingBoy.park(car4);
        Ticket fetchTicket5 = smartParkingBoy.park(car5);
        Ticket fetchTicket6 = smartParkingBoy.park(car6);
        Ticket fetchTicket7 = smartParkingBoy.park(car7);
        Ticket fetchTicket8 = smartParkingBoy.park(car8);
        Ticket fetchTicket9 = smartParkingBoy.park(car9);
        Ticket fetchTicket10 = smartParkingBoy.park(car10);
        Ticket fetchTicket11 = smartParkingBoy.park(car11);  //parking the car to the min size of parkingLot
        System.out.println(list.get(0).size());
        System.out.println(list.get(1).size());
        System.out.println(fetchTicket11);

        //when
        //String tipMessage = parkingBoy.giveTipMessageByFetchCar(null); //when giving the wrong ticket

        Car fetchedCar11 = smartParkingBoy.fetchCar(fetchTicket11);
        //then

        Assertions.assertSame(fetchedCar11, car11);
    }
}
