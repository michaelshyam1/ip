import java.util.Scanner;

public class Tony {
    public static void main(String[] args) {
        String line;
        Scanner in = new Scanner(System.in);
        Task[] tasks = new Task[100];
        int taskCount = 0;

        System.out.println("    ____________________________________________________________");
        System.out.println("     Hello! I'm Tony");
        System.out.println("     What can I do for you?");
        System.out.println("    ____________________________________________________________");

        while (true) {
            line = in.nextLine();
            System.out.println("    ____________________________________________________________");

            String command = line.split(" ")[0];

            switch (command) {
            case "bye":
                System.out.println("      Bye. Hope to see you again soon!");
                System.out.println("    ____________________________________________________________");
                return;
            case "list":
                //Display all tasks in order
                System.out.println("    Here are the tasks in your list:");
                for (int i = 0; i < taskCount; i++) {
                    System.out.println("      " + (i + 1) + "." + tasks[i]);
                }
                System.out.println("    ____________________________________________________________");
                break;
            case "mark":
                //mark task as done
                int markNumber = Integer.parseInt(line.substring(5)) - 1;
                tasks[markNumber].markAsDone();
                System.out.println("       Nice! I've marked this task as done:");
                System.out.println("          " + tasks[markNumber]);
                System.out.println("    ____________________________________________________________");
                break;
            case "unmark":
                //mark task as undone
                int unmarkNumber = Integer.parseInt(line.substring(7)) - 1;
                tasks[unmarkNumber].markAsNotDone();
                System.out.println("       OK, I've marked this task as not done yet:");
                System.out.println("          " + tasks[unmarkNumber]);
                System.out.println("    ____________________________________________________________");
                break;

            case "todo":
                //handle error
                if (line.trim().equals("todo")) {
                    System.out.println("       AHHHH ~ todo cannot be empty!!");
                    System.out.println("    ____________________________________________________________");
                    break;
                }
                String todoDescription = line.substring(5);
                tasks[taskCount] = new Todo(todoDescription);
                taskCount++;
                System.out.println("       Got it. I've added this task:");
                System.out.println("          " + tasks[taskCount - 1]);
                System.out.println("    Now you have " + taskCount + " tasks in the list");
                System.out.println("    ____________________________________________________________");
                break;
            case "deadline":
                if (line.trim().equals("deadline")) {
                    System.out.println("       AHHHH ~ deadline cannot be empty!!");
                    System.out.println("    ____________________________________________________________");
                    break;
                }
                String[] deadlineParts = line.substring(9).split(" /by ");
                String deadlineDescription = deadlineParts[0];
                String by = deadlineParts[1];
                tasks[taskCount] = new Deadline(deadlineDescription, by);
                taskCount++;
                System.out.println("       Got it. I've added this task:");
                System.out.println("          " + tasks[taskCount - 1]);
                System.out.println("    Now you have " + taskCount + " tasks in the list");
                System.out.println("    ____________________________________________________________");
                break;
            case "event":
                //handle error
                if (line.trim().equals("event")) {
                    System.out.println("       AHHHH ~ event cannot be empty!!");
                    System.out.println("    ____________________________________________________________");
                    break;
                }
                String eventContent = line.substring(6);
                String[] firstSplit = eventContent.split(" /from ");
                String eventDescription = firstSplit[0];
                String[] secondSplit = firstSplit[1].split(" /to ");
                String from = secondSplit[0];
                String to = secondSplit[1];

                tasks[taskCount] = new Event(eventDescription, from, to);
                taskCount++;
                System.out.println("       Got it. I've added this task:");
                System.out.println("          " + tasks[taskCount - 1]);
                System.out.println("    Now you have " + taskCount + " tasks in the list");
                System.out.println("    ____________________________________________________________");
                break;
            default:
                System.out.println("      ⚠\uFE0F Invalid command! ");
                System.out.println("    ____________________________________________________________");
                break;
            }
        }
    }
}
