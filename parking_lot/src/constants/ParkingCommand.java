package constants;

public enum ParkingCommand {

    CREATE_PARKING_LOT("create_parking_lot"),
    PARK("park"),
    LEAVE("leave"),
    STATUS("status"),
    REGISTRATION_NUMBERS_WITH_COLOR("registration_numbers_for_cars_with_colour "),
    SLOT_NUMBERS_WITH_COLOR("slot_numbers_for_cars_with_colour "),
    SLOT_NUMBER_FOR_REG_NUMBER("slot_number_for_registration_number "),

    EXIT("EXIT");


    private final String commandName;

    ParkingCommand(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }
}
