import java.util.Scanner;

public class Tony {
    public static void main(String[] args) {
        String line;
        Scanner in = new Scanner(System.in);

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
            }
            System.out.println("     " + line);
            System.out.println("    ____________________________________________________________");
        }
    }
}
