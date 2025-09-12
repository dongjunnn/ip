package Coffee;

/**
 * Represents a command to delete a task from the task list.
 * The command parses the user input for the task index,
 * removes the corresponding task, saves the updated list,
 * and displays confirmation.
 */
public class DeleteCommand extends Command {

    private final int index;

    /**
     * Constructs a {@code DeleteCommand} with the given task index.
     *
     * @param args User input string containing the index of the task to delete.
     *             The value is trimmed and parsed into an integer.
     */
    public DeleteCommand(String args) {
        this.index = Integer.parseInt(args.trim());
    }

    /**
     * Executes the command by deleting the specified task from the task list.
     * Saves the updated list to storage and displays confirmation messages to the user.
     *
     * @param tasks Task list from which the task will be deleted.
     * @param ui User interface for displaying messages.
     * @param storage Storage for saving the updated task list.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        try {
            Task removed = tasks.deleteTask(index);
            storage.save(tasks.view());
            ui.showMessage("Noted. I've removed this task:\n" + removed);
            ui.showMessage("Now you have " + tasks.size() + " tasks in the list.");
        } catch (IndexOutOfBoundsException e) {
            ui.showMessage(e.getMessage());
        }
    }
}
