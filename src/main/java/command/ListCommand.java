package command;

import storage.Storage;
import task.TaskList;
import ui.Ui;

/**
 * Represents a command that displays all tasks in the task list.
 */
public class ListCommand extends Command {
    /**
     * Executes the list command by displaying the current tasks.
     *
     * @param tasks the current task list
     * @param ui the user interface
     * @param storage the storage handler
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showTaskList(tasks);
    }

    /**
     * Indicates whether this command exits the program.
     *
     * @return false since list does not terminate the application
     */
    @Override
    public boolean isExit() {
        return false;
    }
}