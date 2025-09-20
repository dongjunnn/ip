package Coffee;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CommandUtil {
    public static void addSaveAndAck(String description, TaskList tasks, Ui ui, Storage storage) {
        ToDo t = new ToDo(description);
        tasks.addTask(t);
        storage.save(tasks.view());
        ui.showMessage("Got it. I've added this task:\n" + t);
        ui.showMessage("Now you have " + tasks.size() + " tasks in the list.");
    }

    public static void addDeadlineSaveAndAck(String description, String by, TaskList tasks, Ui ui, Storage storage) {
        Deadline d = new Deadline(description, by);
        tasks.addTask(d);
        storage.save(tasks.view());
        ui.showMessage("Got it. I've added this task:\n" + d);
        ui.showMessage("Now you have " + tasks.size() + " tasks in the list.");
    }

    public static void addEventSaveAndAck(String description, String from, String to, TaskList tasks,
                                          Ui ui, Storage storage) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
        LocalDateTime newFrom = LocalDateTime.parse(from, formatter);
        LocalDateTime newTo = LocalDateTime.parse(to, formatter);

        for (Task t : tasks.view()) {
            if (t instanceof Event) {
                Event e = (Event) t;
                // Check for overlap: (startA < endB) && (endA > startB)
                if (newFrom.isBefore(e.to) && newTo.isAfter(e.from)) {
                    ui.showMessage("Error: This event overlaps with an existing event.");
                    return;
                }
            }
        }

        Event e = new Event(description, from, to);
        tasks.addTask(e);
        storage.save(tasks.view());
        ui.showMessage("Got it. I've added this task:\n" + e);
        ui.showMessage("Now you have " + tasks.size() + " tasks in the list.");
    }

}
