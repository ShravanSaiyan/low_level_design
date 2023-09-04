package commands;

import constants.ParkingCommand;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutorFactory {

    private final Map<String, CommandExecutor> commands = new HashMap<>();

    public CommandExecutorFactory() {
        commands.put(ParkingCommand.CREATE_PARKING_LOT.getCommandName(), new CreateParkingLotCommandExecutor());
    }

    public CommandExecutor getCommand(String commandName) throws Exception {
        if (commands.containsKey(commandName)) {
            return commands.get(commandName);
        }
        throw new Exception("Invalid Command");
    }
}
