package service.impl;

import model.Car;
import model.Slot;
import printer.OutputPrinter;
import service.ParkingLot;
import service.ParkingService;
import strategy.ParkingStrategy;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

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
    public void park(Car car) throws Exception {
        checkWhetherParkingLotExists();
        try {
            int availableSlot = parkingStrategy.getNextSlot();
            Slot slot = new Slot(String.valueOf(availableSlot), car);
            parkingLot.assignSlot(slot);
            parkingStrategy.removeSlot(availableSlot);
            OutputPrinter.parkCarMessage(availableSlot);
        } catch (NoSuchElementException e) {
            OutputPrinter.slotsFullMessage();
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
    public void parkingLotStatus() throws Exception {
        checkWhetherParkingLotExists();
        List<Slot> parkingSlots = parkingLot.getSlots().values().stream().toList();
        printSlotInformation(parkingSlots);
    }

    private void printSlotInformation(List<Slot> parkingSlots) {
        if (checkWhetherSlotsAreEmpty(parkingSlots)) {
            OutputPrinter.emptySlotsMessage();
        }
        OutputPrinter.slotInformationMessage();
        parkingSlots.forEach(slot -> {
            System.out.print(slot.getSlotNumber() + "\t");
            Car parkedCar = slot.getParkedCar();
            System.out.print(parkedCar.getRegistrationNumber() + "\t");
            System.out.print(parkedCar.getColor() + "\t");
            System.out.println();
        });
    }

    private boolean checkWhetherSlotsAreEmpty(List<Slot> parkingSlots) {
        return parkingSlots.isEmpty();
    }

    @Override
    public void getRegistrationNumbersForCarsWithColor(String color) throws Exception {
        checkWhetherParkingLotExists();
        List<Slot> parkingSlots = parkingLot.getSlots().values().stream().filter(slot ->
                slot.getParkedCar().getColor().equals(color)
        ).collect(Collectors.toList());
        printRegistrationCarInformation(parkingSlots);
    }

    private void printRegistrationCarInformation(List<Slot> parkingSlots) {
        if (checkWhetherSlotsAreEmpty(parkingSlots)) OutputPrinter.noCarsAvailableMessage();
        parkingSlots.forEach(slot -> {
            Car parkedCar = slot.getParkedCar();
            System.out.print(parkedCar.getRegistrationNumber() + ", ");
        });
    }

    @Override
    public void getSlotNumbersForCarsWithColor(String color) throws Exception {
        checkWhetherParkingLotExists();
        List<Slot> parkingSlots = parkingLot.getSlots().values().stream()
                .filter(slot -> slot.getParkedCar().getColor().equals(color)).toList();
        printSlotsForRegCarInformation(parkingSlots);
    }

    private void printSlotsForRegCarInformation(List<Slot> parkingSlots) {
        if (checkWhetherSlotsAreEmpty(parkingSlots)) OutputPrinter.emptySlotsMessage();
        parkingSlots.forEach(slot -> System.out.print(slot.getSlotNumber() + ", "));
    }

    @Override
    public void getSlotNumberForRegistrationNumber(String registrationNumber) throws Exception {
        checkWhetherParkingLotExists();
        List<Slot> parkingSlots = parkingLot.getSlots().values().stream()
                .filter(slot -> slot.getParkedCar().getRegistrationNumber().equals(registrationNumber)).toList();
        printSlotsForRegCarInformation(parkingSlots);
    }
}
