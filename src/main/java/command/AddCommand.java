package command;

import exception.TonyException;
import storage.Storage;
import task.Deadline;
import task.Event;
import task.Task;
import task.TaskList;
import task.Todo;
import ui.Ui;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Represents a command that adds a new task to the task list
 */
public class AddCommand extends Command {
    private final String taskType;
    private final String arguments;

    /**
     * Creates an AddCommand with the specified task type and arguments.
     *
     * @param taskType type of task to add
     * @param arguments user input associated with the task
     */
    public AddCommand(String taskType, String arguments) {
        this.taskType = taskType;
        this.arguments = arguments;
    }

    /**
     * Executes the add command by creating a task, adding it to the task list,
     * showing the success message, and saving the updated list.
     *
     * @param tasks the current task list
     * @param ui the user interface
     * @param storage the storage handler
     * @throws TonyException if the task input is invalid
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws TonyException {
        if (arguments.trim().isEmpty()) {
            throw new TonyException("AHHHH ~ " + taskType + " cannot be empty!!");
        }

        Task task = createTask();
        tasks.add(task);
        ui.showTaskAdded(task, tasks.size());
        storage.saveTasks(tasks.getTasks());
    }

    /**
     * Creates a task based on the task type and user arguments.
     *
     * @return the created task
     * @throws TonyException if the task format is invalid
     */
    private Task createTask() throws TonyException {
        switch (taskType) {
        case "todo":
            return new Todo(arguments);
        case "deadline":
            String[] deadlineParts = arguments.split(" /by ", 2);
            if (deadlineParts.length < 2 || deadlineParts[0].trim().isEmpty() || deadlineParts[1].trim().isEmpty()) {
                throw new TonyException("Invalid format! Use: deadline DESCRIPTION /by dd-MM-yyyy HHmm");
            }

            //date and time implemented
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HHmm");
                LocalDateTime deadline = LocalDateTime.parse(deadlineParts[1].trim(), formatter);
                return new Deadline(deadlineParts[0].trim(), deadline);
            } catch(DateTimeParseException e) {
                throw new TonyException("Invalid date/time format! Please enter dd-MM-yyyy HHmm (eg. 17-10-2003 1800)");
            }
        case "event":
            String[] firstSplit = arguments.split(" /from ");
            if (firstSplit.length < 2) {
                throw new TonyException("Invalid format! Use: event DESCRIPTION /from TIME /to TIME");
            }
            String[] secondSplit = firstSplit[1].split(" /to ");
            if (secondSplit.length < 2) {
                throw new TonyException("Invalid format! Use: event DESCRIPTION /from TIME /to TIME");
            }
            return new Event(firstSplit[0], secondSplit[0], secondSplit[1]);
        default:
            throw new TonyException("Unknown task type!");
        }
    }

    /**
     * Returns whether this command exits the application.
     *
     * @return false, since add does not exit the program
     */
    @Override
    public boolean isExit() {
        return false;
    }
}