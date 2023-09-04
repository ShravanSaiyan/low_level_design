package service;

import model.Slot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private static final int initialParkingCapacity = 1000;

    private final int capacity;
    private final Map<String, Slot> slots;

    public ParkingLot(int capacity) throws Exception {

        if (capacity > initialParkingCapacity) {
            throw new Exception("Invalid Space: Trying to allocate more parking capacity");
        }

        this.capacity = capacity;
        this.slots = new HashMap<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public Map<String, Slot> getSlots() {
        return slots;
    }

    public void assignSlot(Slot slot) throws Exception {

        if (isSlotNotAvailable(slot.getSlotNumber())) {
            throw new Exception("Slot already assigned");
        }
        slots.put(slot.getSlotNumber(), slot);

    }

    private boolean isSlotNotAvailable(String slotNumber) {
        return !slots.containsKey(slotNumber);
    }

    public void makeSlotFree(String slotNumber) throws Exception {
        if (isSlotNotAvailable(slotNumber)) {
            throw new Exception("Slot not available");
        }
        slots.remove(String.valueOf(slotNumber));
    }
}
