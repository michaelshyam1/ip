package command;

import exception.TonyException;
import storage.Storage;
import task.Task;
import task.TaskList;
import ui.Ui;

public class DeleteCommand extends Command {
    private final String arguments;

    public DeleteCommand(String arguments) {
        this.arguments = arguments;
    }

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

    @Override
    public boolean isExit() {
        return false;
    }
}