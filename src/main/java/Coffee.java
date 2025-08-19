import java.util.Scanner;

public class Coffee {
    public static void main(String[] args) {
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

        while (true) {
            user_input = sc.nextLine();

            if (user_input.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!\n");
                break;
            } else {
                System.out.println(user_input + "\n");
            }

        }
    }
}
