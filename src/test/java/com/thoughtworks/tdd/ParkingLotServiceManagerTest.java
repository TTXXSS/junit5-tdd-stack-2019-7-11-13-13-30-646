package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ParkingLotServiceManagerTest {
    @Test
    public void parkingLotServiceManager_manage_the_three_kinds_of_parkingboy() {
        //Given
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        Map<Ticket, Car> map1 = new HashMap<>();
        ParkingLot parkingLot1 = new ParkingLot();
        Map<Ticket, Car> map2 = new HashMap<>();
        ParkingLot parkingLot2 = new ParkingLot();
        Map<Ticket, Car> map3 = new HashMap<>();
        ParkingLot parkingLot3 = new ParkingLot();
        parkingLot1.setMap(map1);
        parkingLot2.setMap(map2);
        parkingLot3.setMap(map3);
        List<Map<Ticket, Car>> list1 = new ArrayList<>();
        list1.add(parkingLot1.getMap());
        List<Map<Ticket, Car>> list2 = new ArrayList<>();
        list2.add(parkingLot2.getMap());
        List<Map<Ticket, Car>> list3 = new ArrayList<>();
        list3.add(parkingLot3.getMap());

        ParkingBoy parkingBoy = new ParkingBoy(list1);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(list2);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(list3);

        Ticket fetchTicket1 = parkingBoy.park(car1);//parking the car by three kinds of parkingboy in their own parkingLot
        Ticket fetchTicket2 = smartParkingBoy.park(car2);
        Ticket fetchTicket3 = superSmartParkingBoy.park(car3);

        List<ParkingBoy> listOfThreeKindsParkingBoy = new ArrayList<>();//add three kinds of parkingBoy in the list,which is managed by the manager
        listOfThreeKindsParkingBoy.add(parkingBoy);
        listOfThreeKindsParkingBoy.add(smartParkingBoy);
        listOfThreeKindsParkingBoy.add(superSmartParkingBoy);

        ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager();
        parkingLotServiceManager.setListOfParkingBoy(listOfThreeKindsParkingBoy);
        ParkingBoy getParkingBoyByIndex = parkingLotServiceManager.getParkingBoyByIndex(parkingLotServiceManager.getListOfParkingBoy(), 0);//get three kind parkingboy
        SmartParkingBoy getSmartParkingBoyByIndex = (SmartParkingBoy)
                parkingLotServiceManager.getParkingBoyByIndex(parkingLotServiceManager.getListOfParkingBoy(), 1);
        SuperSmartParkingBoy getSuperSmartParkingBoyByIndex =
                (SuperSmartParkingBoy) parkingLotServiceManager.getParkingBoyByIndex(parkingLotServiceManager.getListOfParkingBoy(), 2);


        //when
        Car fetchedCar1 = getParkingBoyByIndex.fetchCar(fetchTicket1);
        Car fetchedCar2 = getSmartParkingBoyByIndex.fetchCar(fetchTicket2);
        Car fetchedCar3 = getSuperSmartParkingBoyByIndex.fetchCar(fetchTicket3);

        //then
        Assertions.assertSame(fetchedCar1, car1);
        Assertions.assertSame(fetchedCar2, car2);
        Assertions.assertSame(fetchedCar3, car3);
    }

    @Test
    public void manager_can_manage_his_own_parkingLot_as_a_standard_parkingboy() {
        //Given
        Car car = new Car();
        Map<Ticket, Car> map = new HashMap<>();
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setMap(map);
        List<Map<Ticket, Car>> list = new ArrayList<>();
        list.add(parkingLot.getMap());
        ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager();
        parkingLotServiceManager.setListOfParkingLot(list);
        Ticket ticket = new Ticket();
        Ticket fetchTicket = parkingLotServiceManager.park(car);
        //when
        Car fetchedCar = parkingLotServiceManager.fetchCar(fetchTicket);
        //System.out.println(fetchedCar);

        //then

        Assertions.assertSame(fetchedCar, car);
    }

    @Test
    public void should_return_unrecognized_parking_ticket_by_manager_from_parkingboy(){
        //Given
        Car car1 = new Car();
        Map<Ticket, Car> map1 = new HashMap<>();
        ParkingLot parkingLot1 = new ParkingLot();

        parkingLot1.setMap(map1);

        List<Map<Ticket, Car>> list1 = new ArrayList<>();
        list1.add(parkingLot1.getMap());


        ParkingBoy parkingBoy = new ParkingBoy(list1);

        Ticket ticket = new Ticket();//create a wrong ticket
        Ticket fetchTicket1 = parkingBoy.park(car1);//parking the car by three kinds of parkingboy in their own parkingLot


        List<ParkingBoy> listOfThreeKindsParkingBoy = new ArrayList<>();//add three kinds of parkingBoy in the list,which is managed by the manager
        listOfThreeKindsParkingBoy.add(parkingBoy);

        ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager();
        parkingLotServiceManager.setListOfParkingBoy(listOfThreeKindsParkingBoy);
        ParkingBoy getParkingBoyByIndex = parkingLotServiceManager.getParkingBoyByIndex(parkingLotServiceManager.getListOfParkingBoy(), 0);//get three kind parkingboy


        //when
        String tipMessage = getParkingBoyByIndex.giveTipMessageByFetchCar(ticket); //when giving the wrong ticket
       // Car fetchedCar = parkingBoy.fetchCar(fetchTicket); //the ticket has been used
        //String tipMessage1 = parkingBoy.giveTipMessageByFetchCar(fetchTicket);

        //then

        assertThat(tipMessage, is("Unrecognized parking ticket."));


    }

    @Test
    public void should_return_Please_provide_your_parking_ticket_by_manager_from_parkingboy(){
        //Given
        Car car1 = new Car();
        Map<Ticket, Car> map1 = new HashMap<>();
        ParkingLot parkingLot1 = new ParkingLot();

        parkingLot1.setMap(map1);

        List<Map<Ticket, Car>> list1 = new ArrayList<>();
        list1.add(parkingLot1.getMap());


        ParkingBoy parkingBoy = new ParkingBoy(list1);

        Ticket fetchTicket1 = parkingBoy.park(car1);//parking the car by three kinds of parkingboy in their own parkingLot


        List<ParkingBoy> listOfThreeKindsParkingBoy = new ArrayList<>();//add three kinds of parkingBoy in the list,which is managed by the manager
        listOfThreeKindsParkingBoy.add(parkingBoy);

        ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager();
        parkingLotServiceManager.setListOfParkingBoy(listOfThreeKindsParkingBoy);
        ParkingBoy getParkingBoyByIndex = parkingLotServiceManager.getParkingBoyByIndex(parkingLotServiceManager.getListOfParkingBoy(), 0);//get three kind parkingboy


        //when
        String tipMessage = getParkingBoyByIndex.giveTipMessageByFetchCar(null); //when giving the wrong ticket
        // Car fetchedCar = parkingBoy.fetchCar(fetchTicket); //the ticket has been used
        //String tipMessage1 = parkingBoy.giveTipMessageByFetchCar(fetchTicket);

        //then

        assertThat(tipMessage, is("Please provide your parking ticket."));
    }

    @Test
    public void should_return_Not_enough_position_by_manager_from_parkingboy(){
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
        Map<Ticket, Car> map1 = new HashMap<>();
        ParkingLot parkingLot1 = new ParkingLot();

        parkingLot1.setMap(map1);

        List<Map<Ticket, Car>> list1 = new ArrayList<>();
        list1.add(parkingLot1.getMap());


        ParkingBoy parkingBoy = new ParkingBoy(list1);

        Ticket fetchTicket1 = parkingBoy.park(car1);
        Ticket fetchTicket2 = parkingBoy.park(car2);
        Ticket fetchTicket3 = parkingBoy.park(car3);
        Ticket fetchTicket4 = parkingBoy.park(car4);
        Ticket fetchTicket5 = parkingBoy.park(car5);
        Ticket fetchTicket6 = parkingBoy.park(car6);
        Ticket fetchTicket7 = parkingBoy.park(car7);
        Ticket fetchTicket8 = parkingBoy.park(car8);
        Ticket fetchTicket9 = parkingBoy.park(car9);
        Ticket fetchTicket10 = parkingBoy.park(car10);
        Ticket fetchTicket11 = parkingBoy.park(car11);

        List<ParkingBoy> listOfThreeKindsParkingBoy = new ArrayList<>();//add three kinds of parkingBoy in the list,which is managed by the manager
        listOfThreeKindsParkingBoy.add(parkingBoy);

        ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager();
        parkingLotServiceManager.setListOfParkingBoy(listOfThreeKindsParkingBoy);
        ParkingBoy getParkingBoyByIndex = parkingLotServiceManager.getParkingBoyByIndex(parkingLotServiceManager.getListOfParkingBoy(), 0);//get three kind parkingboy


        //when
        String tipMessage11 = parkingBoy.giveTipMessageByFetchCar(fetchTicket11); //when capacity of parkingLot is full
        // Car fetchedCar = parkingBoy.fetchCar(fetchTicket); //the ticket has been used
        //String tipMessage1 = parkingBoy.giveTipMessageByFetchCar(fetchTicket);

        //then

        assertThat(tipMessage11, is("Not enough position."));

    }
}
