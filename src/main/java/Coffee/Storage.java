package Coffee;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.nio.file.Path;
import java.util.List;

/**
 * Handles reading from and writing to the storage file for tasks.
 */
public class Storage {

    private final Path filePath;

    /**
     * Constructs a {@code Storage} instance with the given file path.
     *
     * @param filePath Path to the storage file.
     */
    public Storage(String filePath) {
        this.filePath = Paths.get(filePath);
    }

    /**
     * Loads tasks from the storage file.
     *
     * @return List of tasks loaded from the file. Returns an empty list if the file does not exist.
     */
    public ArrayList<Task> load() {
        ArrayList<Task> list = new ArrayList<>();
        if (!Files.exists(filePath)) return list;
        try {
            System.out.println("Looking for: " + filePath.toAbsolutePath());

            for (String line : Files.readAllLines(filePath)) {
                list.add(TaskLoader.fromFileLine(line));
            }
        } catch (IOException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }
        return list;
    }

    /**
     * Saves the given list of tasks to the storage file.
     *
     * @param tasks List of tasks to be saved.
     */
    public void save(List<Task> tasks) {
        try {
            Files.createDirectories(filePath.getParent());
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath.toFile()))) {
                for (Task task : tasks) {
                    writer.write(task.toFileString());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Error writing tasks: " + e.getMessage());
        }
    }
}
