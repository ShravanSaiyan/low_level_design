package service;

import model.Car;
import strategy.ParkingStrategy;

public interface ParkingService {
    void createParkingLot(ParkingLot parkingLot, ParkingStrategy parkingStrategy) throws Exception;

    void park(Car car) throws Exception;

    void unpark(String slotNumber) throws Exception;

    void parkingLotStatus() throws Exception;

    void getRegistrationNumbersForCarsWithColor(String color) throws Exception;

    void getSlotNumbersForCarsWithColor(String color) throws Exception;

    void getSlotNumberForRegistrationNumber(String registrationNumber) throws Exception;

}
