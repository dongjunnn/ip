import java.util.ArrayList;

public class TaskList {

    private ArrayList<Task> taskList = new ArrayList<>();

    public void list() {
        System.out.println("Here are the tasks in your list:");
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

    public void markAsDone(int i) {
        taskList.get(i).markAsDone();
    }

    public void markAsNotDone(int i) {
        taskList.get(i).markAsNotDone();
    }

}
