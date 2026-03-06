package command;

import task.TaskList;
import ui.Ui;
import storage.Storage;
import exception.TonyException;

public abstract class Command {
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws TonyException;
    public abstract boolean isExit();
}