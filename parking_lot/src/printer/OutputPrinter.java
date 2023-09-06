package printer;

public class OutputPrinter {
    public static void printWelcome() {
        printWithNewLine("Welcome to DBZ Parking Lot Service");
    }

    public static void printModeMessage() {
        printWithNewLine("Enter 0 -> File Mode or 1 -> Interactive Mode");
    }

    private static void printWithNewLine(String message) {
        System.out.println(message);
    }

    public static void printCommandMessage() {
        printWithNewLine("Enter the command: To exit the shell type EXIT");
    }


    public static void createParkingLotMessage(int initialCapacity) {
        printWithNewLine("Created the parking lot with " + initialCapacity + " slots");
    }

    public static void parkCarMessage(int slotNumber) {
        printWithNewLine("Parked the Car at " + slotNumber + " slot");
    }

    public static void slotFreeMessage(String slotNumber) {
        printWithNewLine("Slot " + slotNumber + " has been free");
    }
}
