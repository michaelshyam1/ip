package ui;

import task.Task;
import task.TaskList;
import java.util.Scanner;

/**
 * Handles all user interface interactions such as displaying messages
 * and reading user input.
 */
public class Ui {
    private final Scanner scanner;
    private static final String DIVIDER = "    ____________________________________________________________";

    /**
     * Creates a UI object with a scanner for reading user input.
     */
    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Displays a welcome message when the program is initiated.
     */
    public void showWelcome() {
        showLine();
        System.out.println("     Hello! I'm Tony");
        System.out.println("     What can I do for you?");
        showLine();
    }

    /**
     * Prints a divider line user to separate sections
     */
    public void showLine() {
        System.out.println(DIVIDER);
    }

    /**
     * Displays the goodbye message when the user exits.
     */
    public void showGoodbye() {
        System.out.println("      Bye. Hope to see you again soon!");
        showLine();
    }

    /**
     * Displays an error message
     *
     * @param message the error message to display
     */
    public void showError(String message) {
        System.out.println("      " + message);
        showLine();
    }

    /**
     * Displays a confirmation message after a task is added.
     *
     * @param task the task that was added
     * @param totalTasks the total number of tasks in the list
     */
    public void showTaskAdded(Task task, int totalTasks) {
        System.out.println("       Got it. I've added this task:");
        System.out.println("          " + task);
        System.out.println("    Now you have " + totalTasks + " tasks in the list");
        showLine();
    }

    /**
     * Displays a confirmation message after a task is deleted.
     *
     * @param task the task that was removed
     * @param totalTasks the remaining number of tasks
     */
    public void showTaskDeleted(Task task, int totalTasks) {
        System.out.println("       Noted. I've removed this task:");
        System.out.println("          " + task);
        System.out.println("    Now you have " + totalTasks + " tasks in the list.");
        showLine();
    }

    /**
     * Displays a confirmation message after marking or unmarking a task.
     *
     * @param task the task that was updated
     * @param isDone whether the task is marked as done
     */
    public void showTaskMarked(Task task, boolean isDone) {
        if (isDone) {
            System.out.println("       Nice! I've marked this task as done:");
        } else {
            System.out.println("       OK, I've marked this task as not done yet:");
        }
        System.out.println("          " + task);
        showLine();
    }

    /**
     * Displays all tasks currently in the task list.
     *
     * @param tasks the list of tasks to display
     */
    public void showTaskList(TaskList tasks) {
        System.out.println("    Here are the tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println("      " + (i + 1) + "." + tasks.get(i));
        }
        showLine();
    }

    /**
     * Reads a command from the user.
     *
     * @return the user input command
     */
    public String readCommand() {
        System.out.print("     > ");
        return scanner.nextLine();
    }

    /**
     * Displays tasks whose descriptions match the search keyword.
     *
     * @param matchingTasks the list of matching tasks
     */
    public void showMatchingTasks(TaskList matchingTasks) {
        showLine();
        System.out.println("     Here are the matching tasks in your list:");

        int index = 1;
        for (Task task : matchingTasks.getTasks()) {
            System.out.println("     " + index + ". " + task);
            index++;
        }

        if (index == 1) {
            System.out.println("     No matching tasks found.");
        }

        showLine();
    }
}