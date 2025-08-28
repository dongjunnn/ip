public class DeleteCommand extends Command {

    private final int index;

    public DeleteCommand(String args) {
        this.index = Integer.parseInt(args.trim());
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Task removed = tasks.deleteTask(index);
        storage.save(tasks.view());
        ui.showMessage("Noted. I've removed this task:\n" + removed);
        ui.showMessage("Now you have " + tasks.size() + " tasks in the list.");
    }
}
