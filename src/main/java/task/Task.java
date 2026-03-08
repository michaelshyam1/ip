package task;

/**
 * Represents a task with a description and completion status
 */
public class Task {
    private final String description;
    private boolean isDone;

    /**
     * Creates a task with the given description
     *
     * @param description description of the task
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Returns the status icon of the task.
     *
     * @return "[X]" if completed and "[ ]" if not completed
     */
    public String getStatusIcon() {
        return isDone ? "[X]" : "[ ]";
    }

    /**
     * Marks the task as completed
     */
    public void markAsDone() {
        isDone = true;
    }

    /**
     * Marks the tasks as not completed
     */
    public void markAsNotDone() {
        isDone = false;
    }

    /**
     * Returns the description of the task
     *
     * @return task description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns whether a task is completed
     *
     * @return true if done, false if not
     */
    public boolean isDone() {
        return isDone;
    }

    /**
     * Returns the formatted representation of the task
     *
     * @return the representation of the task
     */
    @Override
    public String toString() {
        return getStatusIcon() + " " + description;
    }
}