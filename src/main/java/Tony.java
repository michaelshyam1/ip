import java.util.Scanner;
import java.util.ArrayList;

public class Tony {
    public static void main(String[] args) {
        String line;
        Scanner in = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();

        System.out.println("    ____________________________________________________________");
        System.out.println("     Hello! I'm Tony");
        System.out.println("     What can I do for you?");
        System.out.println("    ____________________________________________________________");

        while (true) {
            line = in.nextLine();
            System.out.println("    ____________________________________________________________");

            String command = line.split(" ")[0];
            try {
                switch (command) {
                case "bye":
                    System.out.println("      Bye. Hope to see you again soon!");
                    System.out.println("    ____________________________________________________________");
                    return;
                case "list":
                    //Display all tasks in order
                    System.out.println("    Here are the tasks in your list:");
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println("      " + (i + 1) + "." + tasks.get(i));
                    }
                    System.out.println("    ____________________________________________________________");
                    break;
                case "mark":
                    //mark task as done
                    int markNumber = Integer.parseInt(line.substring(5)) - 1;
                    tasks.get(markNumber).markAsDone();
                    System.out.println("       Nice! I've marked this task as done:");
                    System.out.println("          " + tasks.get(markNumber));
                    System.out.println("    ____________________________________________________________");
                    break;
                case "unmark":
                    //mark task as undone
                    int unmarkNumber = Integer.parseInt(line.substring(7)) - 1;
                    tasks.get(unmarkNumber).markAsNotDone();
                    System.out.println("       OK, I've marked this task as not done yet:");
                    System.out.println("          " + tasks.get(unmarkNumber));
                    System.out.println("    ____________________________________________________________");
                    break;

                case "todo":
                    //handle error
                    if (line.trim().equals("todo")) {
                        throw new TonyException("       AHHHH ~ todo cannot be empty!!");
                    }
                    String todoDescription = line.substring(5);
                    tasks.add(new Todo(todoDescription));
                    System.out.println("       Got it. I've added this task:");
                    System.out.println("          " + tasks.get(tasks.size() - 1));
                    System.out.println("    Now you have " + tasks.size() + " tasks in the list");
                    System.out.println("    ____________________________________________________________");
                    break;
                case "deadline":
                    if (line.trim().equals("deadline")) {
                        throw new TonyException("       AHHHH ~ deadline cannot be empty!!");
                    }
                    String[] deadlineParts = line.substring(9).split(" /by ");
                    String deadlineDescription = deadlineParts[0];
                    String by = deadlineParts[1];
                    tasks.add(new Deadline(deadlineDescription, by));
                    System.out.println("       Got it. I've added this task:");
                    System.out.println("          " + tasks.get(tasks.size() - 1));
                    System.out.println("    Now you have " + tasks.size() + " tasks in the list");
                    System.out.println("    ____________________________________________________________");
                    break;
                case "event":
                    //handle error
                    if (line.trim().equals("event")) {
                        throw new TonyException("       AHHHH ~ event cannot be empty!!");
                    }
                    String eventContent = line.substring(6);
                    String[] firstSplit = eventContent.split(" /from ");
                    String eventDescription = firstSplit[0];
                    String[] secondSplit = firstSplit[1].split(" /to ");
                    String from = secondSplit[0];
                    String to = secondSplit[1];

                    tasks.add(new Event(eventDescription, from, to));
                    System.out.println("       Got it. I've added this task:");
                    System.out.println("          " + tasks.get(tasks.size() - 1));
                    System.out.println("    Now you have " + tasks.size() + " tasks in the list");
                    System.out.println("    ____________________________________________________________");
                    break;
                case "delete":
                    if (line.trim().equals("delete")) {
                        throw new TonyException("OOPS!!! Please specify which task to delete. Use: delete TASK_NUMBER");
                    }
                    int deleteNumber = Integer.parseInt(line.substring(7)) - 1;
                    if (deleteNumber < 0 || deleteNumber >= tasks.size()) {
                        throw new TonyException("OOPS!!! Task number is out of range!");
                    }
                    Task deletedTask = tasks.remove(deleteNumber);
                    System.out.println("       Noted. I've removed this task:");
                    System.out.println("          " + deletedTask);
                    System.out.println("    Now you have " + tasks.size() + " tasks in the list.");
                    System.out.println("    ____________________________________________________________");
                    break;
                default:
                    throw new TonyException("      ⚠ Invalid command! ");
                }
            } catch(TonyException e) {
                System.out.println("      " + e.getMessage());
                System.out.println("    ____________________________________________________________");
            }

        }
    }
}