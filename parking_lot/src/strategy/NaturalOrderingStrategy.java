package strategy;

import java.util.TreeSet;

public class NaturalOrderingStrategy implements ParkingStrategy {

    private final TreeSet<Integer> treeSet;

    public NaturalOrderingStrategy() {
        this.treeSet = new TreeSet<>();
    }

    @Override
    public void addSlot(int slotNumber) {
        treeSet.add(slotNumber);
    }

    @Override
    public void removeSlot(int slotNumber) {
        treeSet.remove(slotNumber);
    }

    @Override
    public int getNextSlot() {
        return treeSet.first();
    }
}
