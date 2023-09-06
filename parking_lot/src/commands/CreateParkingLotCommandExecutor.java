package commands;

import model.Command;
import printer.OutputPrinter;
import service.ParkingLot;
import service.ParkingService;
import strategy.NaturalOrderingStrategy;

import java.util.List;

public class CreateParkingLotCommandExecutor implements CommandExecutor {

    private final ParkingService parkingService;

    public CreateParkingLotCommandExecutor(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    @Override
    public void processCommand(Command command) throws Exception {
        List<String> params = command.getParams();
        int initialCapacity = Integer.parseInt(params.get(0));
        ParkingLot parkingLot = new ParkingLot(initialCapacity);
        parkingService.createParkingLot(parkingLot, new NaturalOrderingStrategy());
        OutputPrinter.createParkingLotMessage(initialCapacity);
    }

    @Override
    public boolean validate(List<String> params) {
        return params.size() == 1;
    }
}
