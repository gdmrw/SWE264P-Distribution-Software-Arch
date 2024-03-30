import java.io.File;
import java.util.Observable;
import java.util.Observer;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger implements Observer {

    public Logger() {
        // Subscribe to SHOW event.
        try {
            File logFile = new File("log.txt");
            if (logFile.exists()) {
                logFile.delete(); // Delete the file
            }
            logFile.createNewFile(); // Create a new file
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Subscribe to SHOW event.
        EventBus.subscribeTo(EventBus.EV_SHOW, this);
    }

    @Override
    public void update(Observable o, Object arg) {
        // Convert the argument to a string representation, assuming it has a meaningful toString() implementation
        String message = arg.toString();

        // Use try-with-resources to ensure the writer is closed properly
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt", true))) { // true for append mode
            writer.write(message);
            writer.newLine(); // Add a new line for each message for readability
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
