package parser;

import command.AddCommand;
import command.Command;
import command.DeleteCommand;
import command.ExitCommand;
import command.ListCommand;
import command.MarkCommand;
import exception.TonyException;
import command.FindCommand;

public class Parser {

    public static Command parse(String fullCommand) throws TonyException {
        String[] parts = fullCommand.split(" ", 2);
        String commandWord = parts[0];
        String arguments = parts.length > 1 ? parts[1] : "";

        return switch (commandWord) {
            case "bye" -> new ExitCommand();
            case "list" -> new ListCommand();
            case "mark" -> new MarkCommand(arguments, true);
            case "unmark" -> new MarkCommand(arguments, false);
            case "todo" -> new AddCommand("todo", arguments);
            case "deadline" -> new AddCommand("deadline", arguments);
            case "event" -> new AddCommand("event", arguments);
            case "delete" -> new DeleteCommand(arguments);
            case "find" -> new FindCommand(arguments);
            default -> throw new TonyException("⚠ Invalid command!");
        };
    }
}

