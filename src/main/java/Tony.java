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
            }
            else {
                tasks[taskCount] = new Task(line);
                taskCount++;
                System.out.println("     added:" + line);
                System.out.println("    ____________________________________________________________");
            }
        }
    }
}
