package Coffee;

/**
 * Parses full user input strings into executable {@code Command} objects.
 */
public class Parser {

    /**
     * Parses the given full command string into a {@code Command}.
     *
     * @param fullCommand User input string containing a command keyword and optional arguments.
     * @return Corresponding {@code Command} object based on the keyword.
     */
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
        default:
            return new UnknownCommand(fullCommand);
        }
    }
}
