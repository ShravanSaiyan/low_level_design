package strategy;

public interface ParkingStrategy {

    void addSlot(int slotNumber);

    void removeSlot(int slotNumber);

    int getNextSlot();
}
