package task;

/**
 * Represents a todo task
 */
public class Todo extends Task{
    /**
     * Creates a todo task with the description
     *
      * @param description description of the task
     */
    public Todo(String description) {
            super(description);
        }

        public String toString() {
            return "[T]" + super.toString();
        }
}
