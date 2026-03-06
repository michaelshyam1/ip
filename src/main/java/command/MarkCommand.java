package command;

import exception.TonyException;
import storage.Storage;
import task.Task;
import task.TaskList;
import ui.Ui;

public class MarkCommand extends Command {
    private final String arguments;
    private final boolean markAsDone;

    public MarkCommand(String arguments, boolean markAsDone) {
        this.arguments = arguments;
        this.markAsDone = markAsDone;
    }

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
            storage.saveTasks(tasks.getTasks());
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            throw new TonyException("Please provide a valid task number!");
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}