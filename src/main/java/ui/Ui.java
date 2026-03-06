package ui;

import task.Task;
import task.TaskList;

import java.util.Scanner;

public class Ui {
    private Scanner scanner;
    private static final String DIVIDER = "    ____________________________________________________________";

    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    public void showWelcome() {
        showLine();
        System.out.println("     Hello! I'm Tony");
        System.out.println("     What can I do for you?");
        showLine();
    }

    public void showLine() {
        System.out.println(DIVIDER);
    }

    public void showGoodbye() {
        System.out.println("      Bye. Hope to see you again soon!");
        showLine();
    }

    public void showError(String message) {
        System.out.println("      " + message);
        showLine();
    }

    public void showTaskAdded(Task task, int totalTasks) {
        System.out.println("       Got it. I've added this task:");
        System.out.println("          " + task);
        System.out.println("    Now you have " + totalTasks + " tasks in the list");
        showLine();
    }

    public void showTaskDeleted(Task task, int totalTasks) {
        System.out.println("       Noted. I've removed this task:");
        System.out.println("          " + task);
        System.out.println("    Now you have " + totalTasks + " tasks in the list.");
        showLine();
    }

    public void showTaskMarked(Task task, boolean isDone) {
        if (isDone) {
            System.out.println("       Nice! I've marked this task as done:");
        } else {
            System.out.println("       OK, I've marked this task as not done yet:");
        }
        System.out.println("          " + task);
        showLine();
    }

    public void showTaskList(TaskList tasks) {
        System.out.println("    Here are the tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println("      " + (i + 1) + "." + tasks.get(i));
        }
        showLine();
    }

    public String readCommand() {
        return scanner.nextLine();
    }
}