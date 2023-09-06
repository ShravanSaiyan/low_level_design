package commands;

import model.Command;
import service.ParkingService;

import java.util.List;

public class StatusCommandExecutor implements CommandExecutor {
    private final ParkingService parkingService;

    public StatusCommandExecutor(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    @Override
    public void processCommand(Command command) throws Exception {
        parkingService.parkingLotStatus();
    }

    @Override
    public boolean validate(List<String> params) {
        return params.isEmpty();
    }
}
