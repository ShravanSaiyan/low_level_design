package commands;

import model.Command;
import printer.OutputPrinter;
import service.ParkingService;
import service.impl.ParkingServiceImpl;

import java.util.List;

public class CreateParkingLotCommandExecutor implements CommandExecutor {
    @Override
    public void processCommand(Command command) throws Exception {
        List<String> params = command.getParams();
        int initialCapacity = Integer.parseInt(params.get(0));
        ParkingService parkingService = new ParkingServiceImpl();
        parkingService.createParkingLot(initialCapacity);
        OutputPrinter.createParkingLotMessage(initialCapacity);
    }

    @Override
    public boolean validate(List<String> params) {
        return params.size() == 1;
    }
}
