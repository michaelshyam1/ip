package parser;

import command.AddCommand;
import command.Command;
import command.DeleteCommand;
import command.ExitCommand;
import command.ListCommand;
import command.MarkCommand;
import exception.TonyException;
import command.FindCommand;

/**
 *  Parses user input and converts it into executable commands
 */
public class Parser {

    /**
     * Parses a full user command and returns the corresponding Command Object
     * @param fullCommand input entered by the user
     * @return the command represented by the input
     * @throws TonyException if command in not valid
     */
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

