package command;

import exception.TonyException;
import storage.Storage;
import task.Task;
import task.TaskList;
import ui.Ui;

/**
 * Represents a command that deletes a task from the task list.
 */
public class DeleteCommand extends Command {
    private final String arguments;

    /**
     * Creates a DeleteCommand with the given task number argument.
     *
     * @param arguments the task number provided by the user
     */
    public DeleteCommand(String arguments) {
        this.arguments = arguments;
    }

    /**
     * Executes the delete command by removing the specified task
     * from the task list and saving the updated list.
     *
     * @param tasks the current task list
     * @param ui the user interface
     * @param storage the storage handler
     * @throws TonyException if the task number is invalid
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws TonyException {
        if (arguments.trim().isEmpty()) {
            throw new TonyException("Please specify which task to delete. Use: delete TASK_NUMBER");
        }

        try {
            int index = Integer.parseInt(arguments.trim()) - 1;
            if (index < 0 || index >= tasks.size()) {
                throw new TonyException("Task number is out of range!");
            }

            Task deletedTask = tasks.remove(index);
            ui.showTaskDeleted(deletedTask, tasks.size());
            storage.saveTasks(tasks.tasks());
        } catch (NumberFormatException e) {
            throw new TonyException("Please provide a valid task number!");
        }
    }

    /**
     * Indicates whether this command exits the program.
     *
     * @return false since delete does not terminate the application
     */
    @Override
    public boolean isExit() {
        return false;
    }
}