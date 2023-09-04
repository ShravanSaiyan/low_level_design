package mode;

import commands.CommandExecutorFactory;
import constants.ParkingCommand;
import model.Command;
import printer.OutputPrinter;

import java.util.Scanner;

public class InteractiveMode extends Mode {
    public InteractiveMode(CommandExecutorFactory commandExecutorFactory) {
        super(commandExecutorFactory);
    }

    @Override
    public void process() throws Exception {

        while (true) {

            OutputPrinter.printCommandMessage();

            Scanner scanner = new Scanner(System.in);
            String commandInput = scanner.nextLine();


            if (ParkingCommand.EXIT.name().equals(commandInput)) {
                break;
            }

            Command command = new Command(commandInput);
            processCommand(command);

        }
    }
}
