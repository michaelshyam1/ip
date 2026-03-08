package command;

import storage.Storage;
import task.TaskList;
import ui.Ui;

/**
 * Represents the command that exits the application.
 */
public class ExitCommand extends Command {
    /**
     * Executes the exit command by displaying the goodbye message.
     *
     * @param tasks the current task list
     * @param ui the user interface
     * @param storage the storage handler
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showGoodbye();
    }

    /**
     * Indicates that this command causes the program to terminate.
     *
     * @return true since this command exits the application
     */
    @Override
    public boolean isExit() {
        return true;
    }
}