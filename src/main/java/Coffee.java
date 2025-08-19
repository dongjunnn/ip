import java.util.Scanner;
import java.util.ArrayList;

public class Coffee {
    public static void main(String[] args) {
        String horizontalRule =
                "---------------------------------------------";
        String coffee =
                "  ____       __  __           \n" +
                        " / ___|___  / _|/ _| ___  ___ \n" +
                        "| |   / _ \\| |_| |_ / _ \\/ _ \\\n" +
                        "| |__| (_) |  _|  _|  __/  __/\n" +
                        " \\____\\___/|_| |_|  \\___|\\___|\n";

        System.out.println(coffee);
        System.out.println("Hello! I'm Coffee.\n");
        System.out.println("What can I do for you?\n");

        String user_input = "";
        Scanner sc = new Scanner(System.in);

        ArrayList<Task> taskList = new ArrayList<>();

        while (true) {
            user_input = sc.nextLine();
            String[] parts = user_input.split("\\s+", 2);


            if (parts[0].equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!\n");
                break;
            } else if (parts[0].equals("list")) {
                for (int i = 0; i < taskList.size(); i++) {
                    System.out.println(i + 1 + ". " + taskList.get(i));
                }
            } else if (parts[0].equals("mark")) {
                taskList.get(Integer.parseInt(parts[1])-1).markAsDone();
            } else if (parts[0].equals("unmark")) {
                taskList.get(Integer.parseInt(parts[1])-1).markAsNotDone();
            } else {
                System.out.println("added: " + user_input);
                taskList.add(new Task(user_input));
            }
            System.out.println(horizontalRule);
        }
    }
}
