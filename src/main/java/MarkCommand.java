public class MarkCommand extends Command {
    private final int index1Based;

    public MarkCommand(String args) {
        if (args == null || args.trim().isEmpty()) {
            throw new IllegalArgumentException("The mark command format is wrong. Use: mark <index>");
        }
        try {
            this.index1Based = Integer.parseInt(args.trim());
            if (index1Based <= 0) {
                throw new IllegalArgumentException("Index must be a positive integer.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Index must be a positive integer.");
        }
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        if (index1Based > tasks.size()) {
            ui.showMessage("Invalid task index: " + index1Based);
            return;
        }
        tasks.markAsDone(index1Based);
        storage.save(tasks.view());
        ui.showMessage("marked task " + index1Based);
    }
}
