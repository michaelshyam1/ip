package parser;

import command.*;
import exception.TonyException;

public class Parser {

    public static Command parse(String fullCommand) throws TonyException {
        String[] parts = fullCommand.split(" ", 2);
        String commandWord = parts[0];
        String arguments = parts.length > 1 ? parts[1] : "";

        switch (commandWord) {
        case "bye":
            return new ExitCommand();
        case "list":
            return new ListCommand();
        case "mark":
            return new MarkCommand(arguments, true);
        case "unmark":
            return new MarkCommand(arguments, false);
        case "todo":
            return new AddCommand("todo", arguments);
        case "deadline":
            return new AddCommand("deadline", arguments);
        case "event":
            return new AddCommand("event", arguments);
        case "delete":
            return new DeleteCommand(arguments);
        default:
            throw new TonyException("⚠ Invalid command!");
        }
    }
}

