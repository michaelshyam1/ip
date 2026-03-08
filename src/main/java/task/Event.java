package task;

/**
 * Represents an event task with a start and end time.
 */
public class Event extends Task {
    private final String from;
    private final String to;

    /**
     * Creates an event task.
     *
     * @param description description of the event
     * @param from start time
     * @param to end time
     */
    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    /**
     * Returns the start time of the event.
     *
     * @return start time
     */
    public String getFrom() {
        return from;
    }

    /**
     * Returns the start time of the event.
     *
     * @return start time
     */
    public String getTo() {
        return to;
    }

    /**
     * Returns the formatted representation of the event.
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + from + ", to: " + to + ")";
    }
}