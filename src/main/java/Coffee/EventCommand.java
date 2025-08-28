package Coffee;

public class EventCommand extends Command {
    private final String description;
    private final String from;
    private final String to;

    public EventCommand(String args) {
        String[] fromSplit = args.split("/from", 2);
        if (fromSplit.length < 2) {
            throw new IllegalArgumentException("The event command format is wrong. Use: event <desc> /from <time> /to <time>");
        }

        this.description = fromSplit[0].trim();

        String[] toSplit = fromSplit[1].split("/to", 2);
        if (toSplit.length < 2) {
            throw new IllegalArgumentException("The event command format is wrong. Use: event <desc> /from <time> /to <time>");
        }

        this.from = toSplit[0].trim();
        this.to = toSplit[1].trim();
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Event event = new Event(description, from, to);
        tasks.addTask(event);
        storage.save(tasks.view());
        ui.showMessage("Got it. I've added this task:\n" + event);
        ui.showMessage("Now you have " + tasks.size() + " tasks in the list.");
    }
}
