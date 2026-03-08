package task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Returns the formatted representation of the event.
 */
public class Deadline extends Task {
    private final LocalDateTime by;
    private static final DateTimeFormatter OUTPUT_FORMAT = DateTimeFormatter.ofPattern("MMM-dd-yyyy HHmm");

    /**
     * Creates a deadline task.
     *
     * @param description description of the task
     * @param by deadline date and time
     */
    public Deadline(String description, LocalDateTime by) {
        super(description);
        this.by = by;
    }

    /**
     * Returns the deadline date and time.
     *
     * @return deadline
     */
    public LocalDateTime getBy() {
        return by;
    }

    /**
     * Returns the formatted representation of the deadline task.
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by.format(OUTPUT_FORMAT) + ")";
    }
}