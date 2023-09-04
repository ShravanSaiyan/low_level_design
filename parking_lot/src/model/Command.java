package model;

import constants.Constants;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Command {
    private final String name;
    private final List<String> params;

    public Command(String input) throws Exception {

        List<String> commandInput = Arrays.stream(input.trim().split(Constants.SPACE)).map(String::trim)
                .collect(Collectors.toList());

        if (commandInput.isEmpty()) {
            throw new Exception("Invalid Command");
        }

        this.name = commandInput.get(0).toLowerCase();
        commandInput.remove(0);
        this.params = commandInput;
    }

    public String getName() {
        return name;
    }

    public List<String> getParams() {
        return params;
    }
}
