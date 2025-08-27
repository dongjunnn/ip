public class ToDo extends Task {

    public ToDo(String description) throws IllegalArgumentException {
        super(description);
        if (description.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    public String toFileString() {
        return "T | " + super.getStatusIcon() + " | " + description;
    }
}
