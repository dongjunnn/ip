package Coffee;

public class Coffee {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Coffee(String filePath) {
        String coffee =
                "  ____       __  __\n" +
                        " / ___|___  / _|/ _| ___  ___\n" +
                        "| |   / _ \\| |_| |_ / _ \\/ _ \\\n" +
                        "| |__| (_) |  _|  _|  __/  __/\n" +
                        " \\____\\___/|_| |_|  \\___|\\___|\n";

        System.out.println(coffee);
        System.out.println("Hello! I'm Coffee.Coffee.\n");
        System.out.println("What can I do for you?\n");
        ui = new Ui();
        storage = new Storage(filePath);

        try {
            tasks = new TaskList(storage.load());
        } catch (Exception e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }

    public void run() {
        while (true) {
            String full = ui.readCommand();
            try {
                Command c = Parser.parseCommand(full);
                c.execute(tasks, ui, storage);
                if (c.isExit()) {
                    break;
                }
            } catch (IllegalArgumentException e) {
                ui.showMessage(e.getMessage());
            } catch (Exception e) {
                ui.showMessage("Unexpected error: " + e.getMessage());
            }
            LineBreak.printLineBreak();
        }
    }

    public static void main(String[] args) {
        new Coffee("data/tasks.txt").run();
    }
}

