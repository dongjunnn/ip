package Coffee;

public class TodoCommand extends Command {

    private final String description;

    public TodoCommand(String args) {
        this.description = args.trim();
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ToDo t = new ToDo(description);
        tasks.addTask(t);
        storage.save(tasks.view());
        ui.showMessage("Got it. I've added this task:\n" + t);
        ui.showMessage("Now you have " + tasks.size() + " tasks in the list.");
    }
}
