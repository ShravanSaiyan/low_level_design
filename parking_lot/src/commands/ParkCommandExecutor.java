package commands;

import model.Car;
import model.Command;
import printer.OutputPrinter;
import service.ParkingService;

import java.util.List;

public class ParkCommandExecutor implements CommandExecutor {
    private final ParkingService parkingService;

    public ParkCommandExecutor(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    @Override
    public void processCommand(Command command) throws Exception {
        List<String> params = command.getParams();
        Car car = new Car(params.get(0), params.get(1));
        int slotNumber = parkingService.park(car);
        OutputPrinter.parkCarMessage(slotNumber);
    }

    @Override
    public boolean validate(List<String> params) {
        return params.size() == 2;
    }
}
