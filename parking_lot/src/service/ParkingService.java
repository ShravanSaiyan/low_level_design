package service;

import model.Car;
import model.Slot;

public interface ParkingService {
    void createParkingLot(int parkingCapacity) throws Exception;
    void park(Car car) throws Exception;
    void unpark(Slot slot);

    void getRegistrationNumbersForCarsWithColor(String color);
    void getSlotNumbersForCarsWithColor(String color);
    void getSlotNumberForRegistrationNumber(String registrationNumber);

}
