package commands;

import constants.ParkingCommand;
import service.ParkingService;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutorFactory {

    private final Map<String, CommandExecutor> commands = new HashMap<>();


    public CommandExecutorFactory(ParkingService parkingService) {
        commands.put(ParkingCommand.CREATE_PARKING_LOT.getCommandName(),
                new CreateParkingLotCommandExecutor(parkingService));
        commands.put(ParkingCommand.PARK.getCommandName(), new ParkCommandExecutor(parkingService));
        commands.put(ParkingCommand.LEAVE.getCommandName(), new LeaveCommandExecutor(parkingService));
        commands.put(ParkingCommand.STATUS.getCommandName(), new StatusCommandExecutor(parkingService));
        commands.put(ParkingCommand.REGISTRATION_NUMBERS_WITH_COLOR.getCommandName(),
                new RegistrationNumbersForCarsWithColorCommandExecutor(parkingService));
        commands.put(ParkingCommand.SLOT_NUMBER_FOR_REG_NUMBER.getCommandName(),
                new SlotNumbersForCarsWithRegNumberCommandExecutor(parkingService));
        commands.put(ParkingCommand.SLOT_NUMBERS_WITH_COLOR.getCommandName(),
                new SlotNumbersForCarsWithColorCommandExecutor(parkingService));
    }

    public CommandExecutor getCommand(String commandName) throws Exception {
        if (commands.containsKey(commandName)) {
            return commands.get(commandName);
        }
        throw new Exception("Invalid Command");
    }
}
