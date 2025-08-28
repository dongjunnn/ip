package Coffee;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task {

    protected LocalDateTime from;
    protected LocalDateTime to;

    public Event(String description, String from, String to) {
        super(description);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
        this.from = LocalDateTime.parse(from, formatter);
        this.to   = LocalDateTime.parse(to, formatter);
    }

    public Event(String description, String from, String to, boolean isDone) {
        super(description);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
        this.from = LocalDateTime.parse(from, formatter);
        this.to   = LocalDateTime.parse(to, formatter);
        if (isDone) {
            this.markAsDone();
        }
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MMM dd yyyy HH:mm");
        return "[E]" + super.toString() + " (from: " + from.format(fmt)
                + " to: " + to.format(fmt) + ")";
    }

    @Override
    public String toFileString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
        return "E | " + super.getStatusIcon() + " | " + description
                + " | " + from.format(fmt) + " " + to.format(fmt);
    }

}
