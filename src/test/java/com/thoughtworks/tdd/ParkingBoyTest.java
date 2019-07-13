package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class ParkingBoyTest {
    @Test
    public void should_return_car_when_fetch_car_given_have_ticket__by_parking_the_car(){
        //Given
        Car car = new Car();
        Map<Ticket,Car> map = new HashMap<>();
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setMap(map);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Ticket ticket = new Ticket();
        Ticket fetchTicket = parkingBoy.park(car);
        //when
        Car fetchedCar = parkingBoy.fetchCar(fetchTicket);
        //System.out.println(fetchedCar);

        //then

        Assertions.assertSame(fetchedCar,car);
    }
    @Test
    public void should_return_multiply_cars_when_fetch_car_given_have_tickets__by_parking_the_car(){
        //Given
        Car car1 = new Car();
        Car car2 = new Car();
        Map<Ticket,Car> map = new HashMap<>();
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setMap(map);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        //Ticket ticket = new Ticket();
        Ticket fetchTicket1 = parkingBoy.park(car1);
        Ticket fetchTicket2 = parkingBoy.park(car2);

        //when
        Car fetchedCar1 = parkingBoy.fetchCar(fetchTicket1);
        Car fetchedCar2 = parkingBoy.fetchCar(fetchTicket2);
        //System.out.println(fetchedCar);

        //then

        Assertions.assertSame(fetchedCar1,car1);
        Assertions.assertSame(fetchedCar2,car2);

    }

    @Test
    public void should_return_no_cars_when_fetch_car_given_wrong_and_no_ticket__by_parking_the_car(){
        //Given
        Car car1 = new Car();
        Car car2 = new Car();
        Map<Ticket,Car> map = new HashMap<>();
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setMap(map);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        //Ticket ticket = new Ticket();
        Ticket fetchTicket1 = parkingBoy.park(car1); //return the right ticket
        Ticket ticket = new Ticket();   //give a wrong ticket


        //when
        Car fetchedCar1 = parkingBoy.fetchCar(ticket);
        Car fetchedCar2 = parkingBoy.fetchCar(null);
        //System.out.println(fetchedCar);

        //then

        Assertions.assertSame(fetchedCar1,null);
        Assertions.assertSame(fetchedCar2,null);

    }
}
