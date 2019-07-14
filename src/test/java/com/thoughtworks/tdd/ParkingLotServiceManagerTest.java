package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    
}
