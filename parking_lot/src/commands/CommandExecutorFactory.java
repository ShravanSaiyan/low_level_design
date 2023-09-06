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
    }

    public CommandExecutor getCommand(String commandName) throws Exception {
        if (commands.containsKey(commandName)) {
            return commands.get(commandName);
        }
        throw new Exception("Invalid Command");
    }
}
