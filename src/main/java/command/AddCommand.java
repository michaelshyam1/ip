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

public class AddCommand extends Command {
    private final String taskType;
    private final String arguments;

    public AddCommand(String taskType, String arguments) {
        this.taskType = taskType;
        this.arguments = arguments;
    }

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
                throw new TonyException("Invalid date/time format! Please enter dd-mm-yyyy HHmm (eg. 17-10-2003 1800");
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

    @Override
    public boolean isExit() {
        return false;
    }
}