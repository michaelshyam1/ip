package task;

import java.util.ArrayList;

/**
 * Represents a list of tasks and provides operations to manage them
 * @param tasks
 */
public record TaskList(ArrayList<Task> tasks) {
    /**
     * Creates an empty task list
     */
    public TaskList() {
        this(new ArrayList<>());
    }

    /**
     * Adds a task to the task list
     *
     * @param task - task to be added
     */
    public void add(Task task) {
        tasks.add(task);
    }

    /**
     * Removes and returns the task at the specified index
     *
     * @param index index of the task to be removed
     * @return the removed task
     */
    public Task remove(int index) {
        return tasks.remove(index);
    }

    /**
     * Returns the task at the specified index
     *
     * @param index index of the task to retrieve
     * @return the task at the given index
     */
    public Task get(int index) {
        return tasks.get(index);
    }

    /**
     * Returns the number of tasks in the task list
     *
     * @return the number of tasks
     */
    public int size() {
        return tasks.size();
    }

    /**
     * Returns the tasklist containing tasks whose description contains the given keyword
     *
     * @param keyword Keyword to search for based on user
     * @return a task list of matching tasks
     */
    public TaskList find(String keyword) {
        TaskList result = new TaskList();

        for (Task task : tasks) {
            if (task.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(task);
            }
        }
        return result;
    }

    /**
     * Returns the underlying list of tasks
     *
     * @return list of tasks
     */
    public ArrayList<Task> getTasks() {
        return tasks;
    }
}