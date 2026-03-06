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

public class Storage {
    private final String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

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
            type = "T";
        }

        return type + " | " + isDone + " | " + details;
    }

    private Task parseTaskFromFile(String line) {
        try {
            String[] parts = line.split(" \\| ");
            String type = parts[0];
            boolean isDone = parts[1].equals("1");

            Task task = switch (type) {
                case "T" -> new Todo(parts[2]);
                case "D" -> new Deadline(parts[2], parts[3]);
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