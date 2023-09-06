package commands;

import model.Command;
import printer.OutputPrinter;
import service.ParkingService;

import java.util.List;

public class LeaveCommandExecutor implements CommandExecutor {
    private final ParkingService parkingService;

    public LeaveCommandExecutor(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    @Override
    public void processCommand(Command command) throws Exception {
        List<String> params = command.getParams();
        String slotNumber = params.get(0);
        parkingService.unpark(slotNumber);
        OutputPrinter.slotFreeMessage(slotNumber);
    }

    @Override
    public boolean validate(List<String> params) {
        return params.size() == 1 && isInteger(params.get(0));
    }

    private boolean isInteger(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException numberFormatException) {
            return false;
        }

    }
}
