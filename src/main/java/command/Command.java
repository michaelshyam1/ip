package command;

import task.TaskList;
import ui.Ui;
import storage.Storage;
import exception.TonyException;

/**
 * Represents a generic command that can be executed by the application.
 */
public abstract class Command {

    /**
     * Executes the command.
     *
     * @param tasks the list of tasks
     * @param ui the user interface used to display messages
     * @param storage the storage handler for saving tasks
     * @throws TonyException if an error occurs during execution
     */
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws TonyException;

    /**
     * Indicates whether this command causes the program to exit.
     *
     * @return true if the command exits the program, false otherwise
     */
    public abstract boolean isExit();
}