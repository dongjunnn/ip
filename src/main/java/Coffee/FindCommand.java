package Coffee;

import java.util.List;

public class FindCommand extends Command {
    private final String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword.trim();
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        List<Task> matches = tasks.find(keyword);
        ui.showMessage("Here are the matching tasks in your list: ");
        for (Task t: matches) {
            ui.showMessage(t.toString());
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
