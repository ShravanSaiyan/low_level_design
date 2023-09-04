package service.impl;

import model.Car;
import model.Slot;
import service.ParkingLot;
import service.ParkingService;
import strategy.NaturalOrderingStrategy;
import strategy.ParkingStrategy;

public class ParkingServiceImpl implements ParkingService {


    private ParkingLot parkingLot;

    private ParkingStrategy parkingStrategy;


    @Override
    public void createParkingLot(int parkingCapacity) throws Exception {

        parkingLot = new ParkingLot(parkingCapacity);
        parkingStrategy = new NaturalOrderingStrategy();

        for (int i = 0; i < parkingCapacity; i++) {
            parkingStrategy.addSlot(i);
        }
    }

    @Override
    public void park(Car car) throws Exception {

        int availableSlot = parkingStrategy.getNextSlot();

        Slot slot = new Slot(String.valueOf(availableSlot), car);
        parkingLot.assignSlot(slot);
        parkingStrategy.removeSlot(availableSlot);

    }


    @Override
    public void unpark(Slot slot) {

    }

    @Override
    public void getRegistrationNumbersForCarsWithColor(String color) {

    }

    @Override
    public void getSlotNumbersForCarsWithColor(String color) {

    }

    @Override
    public void getSlotNumberForRegistrationNumber(String registrationNumber) {

    }
}
