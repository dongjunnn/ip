import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TaskList {

    private ArrayList<Task> taskList = new ArrayList<>();

    public void list() {
        System.out.println("Here are the tasks in your list:");
        if (taskList.isEmpty()) {
            System.out.println("Nothing =)");
        }
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println(i + 1 + ". " + taskList.get(i));
        }
    }

    public void addTask(Task task) {
        taskList.add(task);
        System.out.println("Got it. I've added this task:");
        System.out.println(task);
        System.out.println("Now you have " + this.taskList.size() + " tasks in the list.");
    }

    public void deleteTask(int i) {
        int index = i - 1;
        System.out.println("Noted. I've removed this task:");
        System.out.println(taskList.get(index));
        taskList.remove(index);
        System.out.println("Now you have " + this.taskList.size() + " tasks in the list.");
    }

    public void markAsDone(int i) {
        int index = i - 1;
        taskList.get(index).markAsDone();
        System.out.println("marked task " + i);
    }

    public void markAsNotDone(int i) {
        int index = i - 1;
        taskList.get(index).markAsNotDone();
        System.out.println("unmarked task " + i);
    }

    public void saveToDisc() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data/tasks.txt"))) {
            Files.createDirectories(Paths.get("data"));
            for (Task task : taskList) {
                writer.write(task.toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing tasks: " + e.getMessage());
        }

    }

}
