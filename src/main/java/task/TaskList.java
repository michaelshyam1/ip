package task;

import java.util.ArrayList;

public record TaskList(ArrayList<Task> tasks) {
    public TaskList() {
        this(new ArrayList<>());
    }

    public void add(Task task) {
        tasks.add(task);
    }

    public Task remove(int index) {
        return tasks.remove(index);
    }

    public Task get(int index) {
        return tasks.get(index);
    }

    public int size() {
        return tasks.size();
    }

    public TaskList find(String keyword) {
        TaskList result = new TaskList();

        for (Task task : tasks) {
            if (task.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(task);
            }
        }
        return result;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }
}