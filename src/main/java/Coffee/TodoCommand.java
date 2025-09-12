package Coffee;

public class TodoCommand extends Command {

    private final String description;

    public TodoCommand(String args) {
        this.description = args.trim();
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        CommandUtil.addSaveAndAck(description, tasks, ui, storage);
    }

}
