package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SuperSmartParkingBoyTest {
    @Test
    public void should_return_car_when_fetch_car_given_have_ticket__by_parking_the_car(){
        //Given
        Car car = new Car();
        Map<Ticket,Car> map = new HashMap<>();
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setMap(map);
        List<Map<Ticket,Car>> list = new ArrayList<>();
        list.add(parkingLot.getMap());
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(list);
        Ticket ticket = new Ticket();
        Ticket fetchTicket = superSmartParkingBoy.park(car);
        //when
        Car fetchedCar = superSmartParkingBoy.fetchCar(fetchTicket);
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
        List<Map<Ticket,Car>> list = new ArrayList<>();
        list.add(parkingLot.getMap());
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(list);
        //Ticket ticket = new Ticket();
        Ticket fetchTicket1 = superSmartParkingBoy.park(car1);
        Ticket fetchTicket2 = superSmartParkingBoy.park(car2);

        //when
        Car fetchedCar1 = superSmartParkingBoy.fetchCar(fetchTicket1);
        Car fetchedCar2 = superSmartParkingBoy.fetchCar(fetchTicket2);
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
        List<Map<Ticket,Car>> list = new ArrayList<>();
        list.add(parkingLot.getMap());
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(list);        //Ticket ticket = new Ticket();
        Ticket fetchTicket1 = superSmartParkingBoy.park(car1); //return the right ticket
        Ticket ticket = new Ticket();   //give a wrong ticket


        //when
        Car fetchedCar1 = superSmartParkingBoy.fetchCar(ticket);
        Car fetchedCar2 = superSmartParkingBoy.fetchCar(null);
        //System.out.println(fetchedCar);

        //then

        Assertions.assertSame(fetchedCar1,null);
        Assertions.assertSame(fetchedCar2,null);

    }

    @Test
    public void should_return_no_cars_when_fetch_car_given_ticket_that_has_been_used_by_parking_the_car(){
        //Given
        Car car1 = new Car();
        // Car car2 = new Car();
        Map<Ticket,Car> map = new HashMap<>();
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setMap(map);
        List<Map<Ticket,Car>> list = new ArrayList<>();
        list.add(parkingLot.getMap());
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(list);        //Ticket ticket = new Ticket();
        //Ticket ticket = new Ticket();
        Ticket fetchTicket1 = superSmartParkingBoy.park(car1); //return the right ticket



        //when
        Car fetchedCar1 = superSmartParkingBoy.fetchCar(fetchTicket1);
        Car fetchedCar2 = superSmartParkingBoy.fetchCar(fetchTicket1); //get the car again when the ticket has been used
        //System.out.println(fetchedCar);

        //then

        Assertions.assertSame(fetchedCar1,car1);
        Assertions.assertSame(fetchedCar2,null);

    }

    @Test
    public void should_no_park_the_car_when_the_capacity_of_parkingLot_is_full_by_parking_the_car(){
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


        // Car car2 = new Car();
        Map<Ticket,Car> map = new HashMap<>();
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setMap(map);
        List<Map<Ticket,Car>> list = new ArrayList<>();
        list.add(parkingLot.getMap());
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(list);        //Ticket ticket = new Ticket();
        //Ticket ticket = new Ticket();
        Ticket fetchTicket1 = superSmartParkingBoy.park(car1); //return the right ticket
        Ticket fetchTicket2 = superSmartParkingBoy.park(car2);
        Ticket fetchTicket3 = superSmartParkingBoy.park(car3);
        Ticket fetchTicket4 = superSmartParkingBoy.park(car4);
        Ticket fetchTicket5 = superSmartParkingBoy.park(car5);
        Ticket fetchTicket6 = superSmartParkingBoy.park(car6);
        Ticket fetchTicket7 = superSmartParkingBoy.park(car7);
        Ticket fetchTicket8 = superSmartParkingBoy.park(car8);
        Ticket fetchTicket9= superSmartParkingBoy.park(car9);
        Ticket fetchTicket10 = superSmartParkingBoy.park(car10);
        Ticket fetchTicket11 = superSmartParkingBoy.park(car11);



        //when
        Car fetchedCar11 = superSmartParkingBoy.fetchCar(fetchTicket11);






        //System.out.println(fetchedCar);

        //then


        Assertions.assertSame(fetchedCar11,null);

    }

    @Test
    public void should_return_tipMessage__when_customer_can_not_fetch_car_by_given_wrong_ticket(){
        //Given
        Car car = new Car();
        Map<Ticket,Car> map = new HashMap<>();
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setMap(map);
        List<Map<Ticket,Car>> list = new ArrayList<>();
        list.add(parkingLot.getMap());
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(list);        //Ticket ticket = new Ticket();
        Ticket ticket = new Ticket();
        Ticket ticket1 = new Ticket();
        Ticket fetchTicket = superSmartParkingBoy.park(car);

        //when
        String tipMessage = superSmartParkingBoy.giveTipMessageByFetchCar(ticket); //when giving the wrong ticket
        Car fetchedCar = superSmartParkingBoy.fetchCar(fetchTicket); //the ticket has been used
        String tipMessage1 = superSmartParkingBoy.giveTipMessageByFetchCar(fetchTicket);

        //then

        assertThat(tipMessage, is("Unrecognized parking ticket."));
        //assertThat(tipMessage1, is("Unrecognized parking ticket."));
    }
    @Test
    public void should_return_tipMessage__when_customer_can_not_fetch_car_by_given_no_ticket(){
        //Given
        Car car = new Car();
        Map<Ticket,Car> map = new HashMap<>();
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setMap(map);
        List<Map<Ticket,Car>> list = new ArrayList<>();
        list.add(parkingLot.getMap());
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(list);
        Ticket ticket = new Ticket();
        Ticket fetchTicket = superSmartParkingBoy.park(car);

        //when
        String tipMessage = superSmartParkingBoy.giveTipMessageByFetchCar(null); //when giving the wrong ticket


        //then

        assertThat(tipMessage, is("Please provide your parking ticket."));
    }

    @Test
    public void should_return_tipMessage__when_customer_can_not_park_car_for_the_capacity_of_parkingLot_is_full(){
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

        Map<Ticket,Car> map = new HashMap<>();
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setMap(map);
        List<Map<Ticket,Car>> list = new ArrayList<>();
        list.add(parkingLot.getMap());
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(list);

        Ticket fetchTicket1 = superSmartParkingBoy.park(car1);
        Ticket fetchTicket2 = superSmartParkingBoy.park(car2);
        Ticket fetchTicket3 = superSmartParkingBoy.park(car3);
        Ticket fetchTicket4 = superSmartParkingBoy.park(car4);
        Ticket fetchTicket5 = superSmartParkingBoy.park(car5);
        Ticket fetchTicket6 = superSmartParkingBoy.park(car6);
        Ticket fetchTicket7 = superSmartParkingBoy.park(car7);
        Ticket fetchTicket8 = superSmartParkingBoy.park(car8);
        Ticket fetchTicket9 = superSmartParkingBoy.park(car9);
        Ticket fetchTicket10 = superSmartParkingBoy.park(car10);
        Ticket fetchTicket11 = superSmartParkingBoy.park(car11);




        //when
        String tipMessage11 = superSmartParkingBoy.giveTipMessageByFetchCar(fetchTicket11); //when capacity of parkingLot is full

//System.out.println(parkingBoy.getParkingLot().get(0).size());
        //then

        assertThat(tipMessage11, is("Not enough position."));
    }
    @Test
    public void should_park_the_car_to_min_rate_of_parkingLot() {
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
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(list);
        Ticket fetchTicket1 = superSmartParkingBoy.park(car1);
        Ticket fetchTicket2 = superSmartParkingBoy.park(car2);
        Ticket fetchTicket3 = superSmartParkingBoy.park(car3);
        Ticket fetchTicket4 = superSmartParkingBoy.park(car4);
        Ticket fetchTicket5 = superSmartParkingBoy.park(car5);
        Ticket fetchTicket6 = superSmartParkingBoy.park(car6);
        Ticket fetchTicket7 = superSmartParkingBoy.park(car7);
        Ticket fetchTicket8 = superSmartParkingBoy.park(car8);
        Ticket fetchTicket9 = superSmartParkingBoy.park(car9);
        Ticket fetchTicket10 = superSmartParkingBoy.park(car10);
        Ticket fetchTicket11 = superSmartParkingBoy.park(car11);  //parking the car to the min size of parkingLot
        System.out.println(list.get(0).size());
        System.out.println(list.get(1).size());
        System.out.println(fetchTicket11);

        //when
        //String tipMessage = parkingBoy.giveTipMessageByFetchCar(null); //when giving the wrong ticket

        Car fetchedCar11 = superSmartParkingBoy.fetchCar(fetchTicket11);
        //then

        Assertions.assertSame(fetchedCar11, car11);
    }
}
