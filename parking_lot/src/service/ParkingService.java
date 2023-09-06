package service;

import model.Car;
import strategy.ParkingStrategy;

public interface ParkingService {
    void createParkingLot(ParkingLot parkingLot, ParkingStrategy parkingStrategy) throws Exception;

    int park(Car car) throws Exception;

    void unpark(String slotNumber) throws Exception;

    void getRegistrationNumbersForCarsWithColor(String color);

    void getSlotNumbersForCarsWithColor(String color);

    void getSlotNumberForRegistrationNumber(String registrationNumber);

}
