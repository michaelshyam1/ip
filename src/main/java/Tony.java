import java.util.Scanner;

public class Tony {
    public static void main(String[] args) {
        String line;
        Scanner in = new Scanner(System.in);
        String[] tasks = new String[100];
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
                for (int i = 0; i < taskCount; i++) {
                    System.out.println("      " + (i + 1) + ". " + tasks[i]);
                }
                System.out.println("    ____________________________________________________________");
            } else {
                tasks[taskCount] = line;
                taskCount++;
                System.out.println("     added:" + line);
                System.out.println("    ____________________________________________________________");
            }
        }
    }
}
