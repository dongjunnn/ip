package Coffee;

public class Parser {
    public static Command parseCommand(String fullCommand) {
        String[] parts = fullCommand.split(" ", 2);
        String keyword = parts[0].toLowerCase();
        String args = parts.length > 1 ? parts[1] : "";

        switch (keyword) {
            case "bye":
                return new ByeCommand();
            case "list":
                return new ListCommand();
            case "todo":
                return new TodoCommand(args);
            case "deadline":
                return new DeadlineCommand(args);
            case "event":
                return new EventCommand(args);
            case "delete":
                return new DeleteCommand(args);
            case "mark":
                return new MarkCommand(args);
            case "unmark":
                return new UnmarkCommand(args);
        case "find":
            return new FindCommand(args);
            default:
                return new UnknownCommand(fullCommand);
        }
    }
}
