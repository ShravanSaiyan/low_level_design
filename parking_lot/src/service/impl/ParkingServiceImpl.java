package service.impl;

import model.Car;
import model.Slot;
import service.ParkingLot;
import service.ParkingService;
import strategy.ParkingStrategy;

import java.util.NoSuchElementException;

public class ParkingServiceImpl implements ParkingService {


    private ParkingLot parkingLot;

    private ParkingStrategy parkingStrategy;


    @Override
    public void createParkingLot(ParkingLot parkingLot, ParkingStrategy parkingStrategy) {

        this.parkingLot = parkingLot;
        this.parkingStrategy = parkingStrategy;
        for (int i = 0; i < parkingLot.getCapacity(); i++) {
            parkingStrategy.addSlot(i);
        }
    }

    @Override
    public int park(Car car) throws Exception {
        checkWhetherParkingLotExists();
        try {
            int availableSlot = parkingStrategy.getNextSlot();
            Slot slot = new Slot(String.valueOf(availableSlot), car);
            parkingLot.assignSlot(slot);
            parkingStrategy.removeSlot(availableSlot);
            return availableSlot;
        } catch (NoSuchElementException e) {
            throw new Exception("Slots are full");
        }
    }

    private void checkWhetherParkingLotExists() throws Exception {
        if (isParkingLotNotAvailable()) {
            throw new Exception("Parking Lot Does not Exist");
        }
    }

    private boolean isParkingLotNotAvailable() {
        return parkingLot == null;
    }

    @Override
    public void unpark(String slotNumber) throws Exception {
        checkWhetherParkingLotExists();
        parkingLot.makeSlotFree(slotNumber);
        parkingStrategy.addSlot(Integer.parseInt(slotNumber));
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
