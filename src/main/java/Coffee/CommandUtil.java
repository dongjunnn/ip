package Coffee;

public class CommandUtil {
    public static void addSaveAndAck(String description, TaskList tasks, Ui ui, Storage storage) {
        ToDo t = new ToDo(description);
        tasks.addTask(t);
        storage.save(tasks.view());
        ui.showMessage("Got it. I've added this task:\n" + t);
        ui.showMessage("Now you have " + tasks.size() + " tasks in the list.");
    }
}
