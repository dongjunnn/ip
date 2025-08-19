import java.util.Scanner;

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

        Scanner sc = new Scanner(System.in);

        TaskList taskList = new TaskList();

        while (true) {
            String line = sc.nextLine();
            String[] parts = line.split("\\s+", 2);
            String cmdWord = parts[0];
            String rest = parts.length > 1 ? parts[1] : "";

            CommandType cmd = CommandType.from(cmdWord);

            switch (cmd) {
                case BYE:
                    System.out.println("Bye. Hope to see you again soon!\n");
                    break;
                case MARK:
                    taskList.markAsDone(Integer.parseInt(rest) - 1);
                    break;
                case UNMARK:
                    taskList.markAsNotDone(Integer.parseInt(rest) - 1);
                    break;
                case LIST:
                    taskList.list();
                    break;
                case TODO:
                    taskList.addTask(new ToDo(rest));
                    break;
                case DEADLINE:
                    String deadlineDescription = rest.split("/by")[0].trim();
                    String by = rest.split("/by")[1].trim();
                    taskList.addTask(new Deadline(deadlineDescription, by));
                    break;
                case EVENT:
                    String[] fromSplit = rest.split("/from", 2);
                    String eventDescription = fromSplit[0].trim();

                    String[] toSplit = fromSplit[1].split("/to", 2);
                    String from = toSplit[0].trim();
                    String to = toSplit[1].trim();

                    taskList.addTask(new Event(eventDescription, from, to));
                    break;
            }

            System.out.println(horizontalRule);
        }

    }
}
