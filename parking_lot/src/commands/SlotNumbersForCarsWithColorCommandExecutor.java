package commands;

import model.Command;
import service.ParkingService;

import java.util.List;

public class SlotNumbersForCarsWithColorCommandExecutor implements CommandExecutor {
    private final ParkingService parkingService;

    public SlotNumbersForCarsWithColorCommandExecutor(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    @Override
    public void processCommand(Command command) throws Exception {
        List<String> params = command.getParams();
        String carColor = params.get(0);
        parkingService.getSlotNumbersForCarsWithColor(carColor);
    }

    @Override
    public boolean validate(List<String> params) {
        return params.size() == 1;
    }
}
