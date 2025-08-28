public class DeadlineCommand extends Command {
    private final String description;
    private final String by;

    public DeadlineCommand(String args) {
        String[] parts = args.split("/by", 2);
        this.description = parts[0].trim();
        this.by = parts.length > 1 ? parts[1].trim() : "";
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Deadline d = new Deadline(description, by);
        tasks.addTask(d);
        storage.save(tasks.view());
        ui.showMessage("Got it. I've added this task:\n" + d);
        ui.showMessage("Now you have " + tasks.size() + " tasks in the list.");
    }
}
