package Coffee;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.nio.file.Path;
import java.util.List;

public class Storage {

    private final Path filePath;

    public Storage(String filePath) {
        this.filePath = Paths.get(filePath);
    }

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
