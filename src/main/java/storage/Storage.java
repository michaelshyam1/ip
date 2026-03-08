package storage;

import task.Deadline;
import task.Event;
import task.Task;
import task.Todo;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;

/**
 * Handles loading tasks from and saving tasks to the storage file.
 */
public class Storage {
    private final String filePath;

    /**
     * Creates a Storage object that uses the specified file path.
     *
     * @param filePath path to the storage file
     */
    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Saves the given list of tasks to the storage file.
     *
     * @param tasks list of tasks to save
     */
    public void saveTasks(ArrayList<Task> tasks) {
        try {
            File file = new File(filePath);
            file.getParentFile().mkdirs(); // Create data folder if it doesn't exist
            FileWriter writer = new FileWriter(file);

            for (Task task : tasks) {
                writer.write(taskToFileFormat(task) + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving tasks to file: " + e.getMessage());
        }
    }

    /**
     * Loads tasks from the storage file.
     *
     * @return a list of tasks loaded from storage
     */
    public ArrayList<Task> loadTasks() {
        ArrayList<Task> tasks = new ArrayList<>();
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                return tasks; // No file yet, return empty list
            }

            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Task task = parseTaskFromFile(line);
                if (task != null) {
                    tasks.add(task);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("No previous data found. Starting fresh!");
        }
        return tasks;
    }

    /**
     * Converts a task into the format used for file storage.
     *
     * @param task task to convert
     * @return formatted string representation of the task
     */
    private String taskToFileFormat(Task task) {
        String type;
        String isDone = task.isDone() ? "1" : "0";
        String details = task.getDescription();

        if (task instanceof Todo) {
            type = "T";
        } else if (task instanceof Deadline d) {
            type = "D";
            details = task.getDescription() + " | " + d.getBy();
        } else if (task instanceof Event e) {
            type = "E";
            details = task.getDescription() + " | " + e.getFrom() + " | " + e.getTo();
        } else {
            throw new IllegalArgumentException("Unknown task type");
        }

        return type + " | " + isDone + " | " + details;
    }

    /**
     * Parses a line from the storage file into a Task object.
     *
     * @param line line read from the storage file
     * @return the parsed task, or null if parsing fails
     */
    private Task parseTaskFromFile(String line) {
        try {
            String[] parts = line.split(" \\| ");
            String type = parts[0];
            boolean isDone = parts[1].equals("1");

            Task task = switch (type) {
                case "T" -> new Todo(parts[2]);
                case "D" -> new Deadline(parts[2], LocalDateTime.parse(parts[3]));
                case "E" -> new Event(parts[2], parts[3], parts[4]);
                default -> null;
            };

            if (task != null && isDone) {
                task.markAsDone();
            }

            return task;
        } catch (Exception e) {
            System.out.println("Error parsing line: " + line);
            return null;
        }
    }
}