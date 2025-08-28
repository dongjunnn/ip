package Coffee;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {

    protected LocalDateTime by;

    public Deadline(String description, String by) {
        super(description);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
        this.by = LocalDateTime.parse(by, formatter);
    }

    public Deadline(String description, String by, boolean isDone) {
        super(description);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
        this.by = LocalDateTime.parse(by, formatter);
        if (isDone) {
            this.markAsDone();
        }
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by.format(DateTimeFormatter.ofPattern("dd/MM/yyyy h:mma")) + ")";
    }

    @Override
    public String toFileString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
        return "D | " + super.getStatusIcon() + " | " + description + " | " + by.format(fmt);
    }

}
