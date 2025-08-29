package Coffee;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class CoffeeTest {

    @Test
    public void constructor_doesNotThrow() {
        // Just check Coffee can be created without errors
        assertDoesNotThrow(() -> new Coffee("data/test_tasks.txt"));
    }
}
