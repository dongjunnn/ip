package Coffee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents a command to delete one or more tasks from the task list.
 * The command parses the user input for space-separated task indices,
 * removes the corresponding tasks, saves the updated list,
 * and displays confirmation.
 */
public class DeleteCommand extends Command {

    private final List<Integer> indices;

    /**
     * Constructs a {@code DeleteCommand} with the given task indices.
     *
     * @param args User input string containing space-separated indices
     *             of the tasks to delete.
     */
    public DeleteCommand(String args) {
        this.indices = Arrays.stream(args.trim().split("\\s+"))
                .map(Integer::parseInt)
                .sorted(Comparator.reverseOrder()) // delete highest index first
                .collect(Collectors.toList());
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        // Collect results of deletions
        List<String> results = indices.stream()
                .map(idx -> {
                    try {
                        Task removed = tasks.deleteTask(idx);
                        return "Noted. I've removed this task:\n" + removed;
                    } catch (IndexOutOfBoundsException e) {
                        return "Invalid index: " + idx;
                    }
                })
                .collect(Collectors.toList());

        storage.save(tasks.view());
        results.forEach(ui::showMessage);
        ui.showMessage("Now you have " + tasks.size() + " tasks in the list.");
    }
}
