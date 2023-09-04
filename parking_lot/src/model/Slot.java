package model;

public class Slot {
    private final String slotNumber;

    private final Car parkedCar;


    public Slot(String slotNumber, Car parkedCar) {
        this.slotNumber = slotNumber;
        this.parkedCar = parkedCar;
    }

    public String getSlotNumber() {
        return slotNumber;
    }

    public Car getParkedCar() {
        return parkedCar;
    }


}
