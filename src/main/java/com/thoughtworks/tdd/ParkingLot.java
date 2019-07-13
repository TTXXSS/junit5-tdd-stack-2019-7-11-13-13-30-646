package com.thoughtworks.tdd;

import java.util.Map;

public class ParkingLot {
    private Map<Ticket, Car> map;

    public Map<Ticket, Car> getMap() {
        return map;
    }

    public void setMap(Map<Ticket, Car> map) {
        this.map = map;
    }
}
