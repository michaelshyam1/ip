package tony;

import command.Command;
import exception.TonyException;
import parser.Parser;
import storage.Storage;
import task.TaskList;
import ui.Ui;

/**
 *This is the main entry point for Tony
 */
public class Tony {
    private final Storage storage;
    private TaskList tasks;
    private final Ui ui;

    /**
     * Creates a Tony application using the given file path for storage
     * @param filePath path to the storage file
     */
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

    /**
     * Runs the main program until the user exits by typing "bye"
     */
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

    /**
     * starts Tony
     * @param args tasks written by the user
     */
    public static void main(String[] args) {
        new Tony("./data/duke.txt").run();
    }
}