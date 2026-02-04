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

            if (line.equals("bye")) {
                System.out.println("      Bye. Hope to see you again soon!");
                System.out.println("    ____________________________________________________________");
                break;
            } else if (line.equals("list")) {
                //Display all tasks in order
                System.out.println("    Here are the tasks in your list:");
                for (int i = 0; i < taskCount; i++) {
                    System.out.println("      " + (i + 1) + "." + tasks[i]);
                }
                System.out.println("    ____________________________________________________________");
            } else if (line.startsWith("mark ")) {
                //mark task as done
                int taskNumber = Integer.parseInt(line.substring(5)) -1;
                tasks[taskNumber].markAsDone();
                System.out.println("       Nice! I've marked this task as done:" );
                System.out.println("          " + tasks[taskNumber]);
                System.out.println("    ____________________________________________________________");
            } else if (line.startsWith("unmark ")) {
                //mark task as undone
                int taskNumber = Integer.parseInt(line.substring(7)) -1;
                tasks[taskNumber].markAsNotDone();
                System.out.println("       OK, I've marked this task as not done yet:" );
                System.out.println("          " + tasks[taskNumber]);
                System.out.println("    ____________________________________________________________");
            } else if (line.startsWith("todo ")) {
                String description = line.substring(5);
                tasks[taskCount] = new Todo(description);
                taskCount++;
                System.out.println("       Got it. I've added this task:");
                System.out.println("          " + tasks[taskCount - 1]);
                System.out.println("    Now you have " + taskCount + " tasks in the list");
                System.out.println("    ____________________________________________________________");
            } else if (line.startsWith("deadline ")) {
                String[] parts = line.substring(9).split(" /by ");
                String description = parts[0];
                String by = parts[1];
                tasks[taskCount] = new Deadline(description, by);
                taskCount++;
                System.out.println("       Got it. I've added this task:");
                System.out.println("          " + tasks[taskCount - 1]);
                System.out.println("    Now you have " + taskCount + " tasks in the list");
                System.out.println("    ____________________________________________________________");
            }  else if (line.startsWith("event ")) {
                String content = line.substring(6);
                String[] firstSplit = content.split(" /from ");
                String description = firstSplit[0];
                String[] secondSplit = firstSplit[1].split(" /to ");
                String from = secondSplit[0];
                String to = secondSplit[1];

                tasks[taskCount] = new Event(description, from, to);
                taskCount++;
                System.out.println("       Got it. I've added this task:");
                System.out.println("          " + tasks[taskCount - 1]);
                System.out.println("    Now you have " + taskCount + " tasks in the list");
                System.out.println("    ____________________________________________________________");

            }else {
                tasks[taskCount] = new Todo(line);
                taskCount++;
                System.out.println("     added:" + line);
                System.out.println("    ____________________________________________________________");
            }
        }
    }
}
