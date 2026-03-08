package command;

import exception.TonyException;
import storage.Storage;
import task.Task;
import task.TaskList;
import ui.Ui;

/**
 * Represents a command that marks or unmarks a task.
 */
public class MarkCommand extends Command {
    private final String arguments;
    private final boolean markAsDone;

    /**
     * Creates a MarkCommand to mark or unmark a task.
     *
     * @param arguments the task number provided by the user
     * @param markAsDone true to mark the task as done, false to unmark it
     */
    public MarkCommand(String arguments, boolean markAsDone) {
        this.arguments = arguments;
        this.markAsDone = markAsDone;
    }

    /**
     * Executes the mark command by updating the task's completion status.
     *
     * @param tasks the current task list
     * @param ui the user interface
     * @param storage the storage handler
     * @throws TonyException if the task number is invalid
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws TonyException {
        try {
            int index = Integer.parseInt(arguments.trim()) - 1;
            Task task = tasks.get(index);

            if (markAsDone) {
                task.markAsDone();
            } else {
                task.markAsNotDone();
            }

            ui.showTaskMarked(task, markAsDone);
            storage.saveTasks(tasks.tasks());
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            throw new TonyException("Please provide a valid task number!");
        }
    }

    /**
     * Indicates whether this command exits the program.
     *
     * @return false since mark does not terminate the application
     */
    @Override
    public boolean isExit() {
        return false;
    }
}