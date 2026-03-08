package command;

import exception.TonyException;
import storage.Storage;
import task.TaskList;
import ui.Ui;

/**
 * Represents a command that searches for tasks containing a given keyword.
 */
public class FindCommand extends Command {
    private final String keyword;

    /**
     * Creates a FindCommand with the specified keyword.
     *
     * @param keyword keyword used to search task descriptions
     */
    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    /**
     * Executes the find command by searching the task list and displaying
     * all tasks whose descriptions contain the keyword.
     *
     * @param tasks the current task list
     * @param ui the user interface
     * @param storage the storage handler
     * @throws TonyException if an error occurs during execution
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws TonyException {
        TaskList matchingTasks = tasks.find(keyword);
        ui.showMatchingTasks(matchingTasks);
    }

    /**
     * Indicates whether this command exits the program.
     *
     * @return false since find does not terminate the application
     */
    @Override
    public boolean isExit() {
        return false;
    }
}