package Coffee;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

public class ToDoTest {

    @Test
    void constructor_blankDescription_throws() {
        assertThrows(IllegalArgumentException.class, () -> new ToDo(" "));
        assertThrows(IllegalArgumentException.class, () -> new ToDo("\t"));
        assertThrows(IllegalArgumentException.class, () -> new ToDo(""));
    }

    @Test
    void toString_hasPrefixT_andContainsDescription() {
        ToDo t = new ToDo("buy milk");
        String s = t.toString();
        assertTrue(s.startsWith("[T]"), "toString() should start with [T]");
        assertTrue(s.contains("buy milk"), "toString() should contain the description");
    }

    @Test
    void toFileString_hasTypeIconAndDescription_inThatOrder() {
        String desc = "finish report";
        ToDo t = new ToDo(desc);

        String fs = t.toFileString(); // "T | <icon> | finish report"

        Pattern p = Pattern.compile("^T\\s*\\|\\s*(.)\\s*\\|\\s*(.*)$");
        Matcher m = p.matcher(fs);
        assertTrue(m.matches(), "toFileString format should be: T | <icon> | <description>");

        String icon = m.group(1);
        String parsedDesc = m.group(2);

        assertEquals(t.getStatusIcon(), icon, "Second part should match status icon");
        assertEquals(desc, parsedDesc, "Third part should be the original description");
    }

    @Test
    void constructor_withIsDoneTrue_setsDoneStatus() {
        ToDo done = new ToDo("read book", true);
        ToDo notDone = new ToDo("read book");

        assertNotEquals(notDone.getStatusIcon(), done.getStatusIcon(),
                "Status icon should differ when constructed with isDone=true");

        String fs = done.toFileString();
        Matcher m = Pattern.compile("^T\\s*\\|\\s*(.)\\s*\\|\\s*(.*)$").matcher(fs);
        assertTrue(m.matches());
        assertEquals(done.getStatusIcon(), m.group(1));
    }
}
