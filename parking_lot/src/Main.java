import commands.CommandExecutorFactory;
import constants.Mode;
import mode.FileMode;
import mode.InteractiveMode;
import printer.OutputPrinter;
import service.ParkingService;
import service.impl.ParkingServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        ParkingService parkingService = new ParkingServiceImpl();
        CommandExecutorFactory commandExecutorFactory = new CommandExecutorFactory(parkingService);
        Scanner scanner = new Scanner(System.in);

        OutputPrinter.printWelcome();
        OutputPrinter.printModeMessage();

        String modeInput = scanner.next();

        if (isFileMode(modeInput)) {
            new FileMode(commandExecutorFactory).process();
        } else if (isInteractiveMode(modeInput)) {
            new InteractiveMode(commandExecutorFactory).process();
        } else {
            throw new Exception("Invalid Mode");
        }
    }

    private static boolean isFileMode(String modeInput) {
        return Mode.FILE.mode == Integer.parseInt(modeInput);
    }

    private static boolean isInteractiveMode(String modeInput) {
        return Mode.INTERACTIVE_SHELL.mode == Integer.parseInt(modeInput);
    }
}

