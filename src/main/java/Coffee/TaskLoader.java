package Coffee;

public class TaskLoader {
    public static Task fromFileLine(String line) {
        System.out.println("Parsing: " + line);
        String[] p = line.split("\\|");
        String type = p[0].trim();

        String status = p[1].trim();
        boolean isDone = "X".equals(status) || "1".equals(status);

        String desc = p[2].trim();

        switch (type) {
            case "T":
                return new ToDo(desc, isDone);

            case "D":
                return new Deadline(desc, p[3].trim(), isDone);

            case "E":
                String[] parts = p[3].trim().split(" ");
                if (parts.length < 4) {
                    throw new IllegalArgumentException("Bad Coffee.Event line: " + line);
                }
                String from = parts[0] + " " + parts[1];
                String to   = parts[2] + " " + parts[3];
                return new Event(desc, from, to, isDone);


            default:
                throw new IllegalArgumentException("Bad save line: " + line);
        }
    }
}
