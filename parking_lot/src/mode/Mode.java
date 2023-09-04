package mode;

import commands.CommandExecutor;
import commands.CommandExecutorFactory;
import model.Command;

public abstract class Mode {

    private final CommandExecutorFactory commandExecutorFactory;

    public Mode(CommandExecutorFactory commandExecutorFactory) {
        this.commandExecutorFactory = commandExecutorFactory;
    }

    public abstract void process() throws Exception;

    public void processCommand(Command command) throws Exception {

        CommandExecutor commandExecutor = commandExecutorFactory.getCommand(command.getName());
        if (!commandExecutor.validate(command.getParams())) {
            throw new Exception("Invalid Command");
        }
        commandExecutor.processCommand(command);
    }
}
