package Coffee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TaskList {

    private ArrayList<Task> taskList = new ArrayList<>();

    public TaskList() {
    }

    public TaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

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
        System.out.println();
    }

    public Task deleteTask(int i) {
        int index = i - 1;
        Task deletedTask = taskList.get(index);
        taskList.remove(index);
        return deletedTask;
    }

    public void markAsDone(int i) {
        int index = i - 1;
        taskList.get(index).markAsDone();
    }

    public void markAsNotDone(int i) {
        int index = i - 1;
        taskList.get(index).markAsNotDone();
    }

    public List<Task> view() {
        return Collections.unmodifiableList(taskList);
    }

    public int size() {
        return this.taskList.size();
    }

    public List<Task> find(String keyword) {
        String needle = keyword.toLowerCase();
        List<Task> out = new ArrayList<>();
        for (Task t : taskList) {
            if (t.description.toLowerCase().contains(needle)) {
                out.add(t);
            }
        }
        return out;
    }

}
