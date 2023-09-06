package commands;

import model.Command;
import service.ParkingService;

import java.util.List;

public class SlotNumbersForCarsWithRegNumberCommandExecutor implements CommandExecutor {
    private final ParkingService parkingService;

    public SlotNumbersForCarsWithRegNumberCommandExecutor(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    @Override
    public void processCommand(Command command) throws Exception {
        List<String> params = command.getParams();
        String carColor = params.get(0);
        parkingService.getSlotNumberForRegistrationNumber(carColor);
    }

    @Override
    public boolean validate(List<String> params) {
        return params.size() == 1;
    }
}
