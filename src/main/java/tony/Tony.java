package tony;

import command.Command;
import exception.TonyException;
import parser.Parser;
import storage.Storage;
import task.TaskList;
import ui.Ui;

public class Tony {
    private final Storage storage;
    private TaskList tasks;
    private final Ui ui;

    public Tony(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.loadTasks());
        } catch (Exception e) {
            ui.showError("Error loading tasks. Starting with empty list.");
            tasks = new TaskList();
        }
    }

    public void run() {
        ui.showWelcome();
        boolean isExit = false;

        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine();
                Command command = Parser.parse(fullCommand);
                command.execute(tasks, ui, storage);
                isExit = command.isExit();
            } catch (TonyException e) {
                ui.showError(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new Tony("./data/duke.txt").run();
    }
}