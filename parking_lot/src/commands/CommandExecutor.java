package commands;

import model.Command;

import java.util.List;

public interface CommandExecutor {

    void processCommand(Command command) throws Exception;

    boolean validate(List<String> params);
}
